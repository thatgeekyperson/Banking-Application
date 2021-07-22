from flask import Flask, request, redirect, url_for
from flask_cors import CORS
import pickle

import database
from Bank import Bank
from ClientFactory import ClientFactory
from Manager import Manager
from SendPaymentReminder import SendPaymentReminder

app = Flask(__name__)
CORS(app)

bank = Bank()
client_factory = ClientFactory(bank)

send_payment_reminder = SendPaymentReminder(bank)
manager = Manager.instance()


@app.route('/')
def index():
    return {'heading': 'Welcome to the App'}


@app.route('/register', methods=['POST', 'GET'])
async def register():
    if request.method == 'POST':
        name = request.form['name']
        username = request.form['username']
        password = request.form['password']
        await database.connect_db()
        await client_factory.create_client(name, username, password)
        return redirect("http://localhost:3000/login")
    if request.method == 'GET':
        return redirect("http://localhost:3000/register")


@app.route('/login', methods=['POST', 'GET'])
def login():
    if request.method == 'POST':
        # message = "You are registered %s" % name
        return redirect("http://localhost:3000/")
        # return {'message': 'Successfully registered!', 'logged_in': True}
    if request.method == 'GET':
        logged_in = request.args['logged_in']
        # if logged_in:
        #     return {'message': 'Successfully registered!', 'logged_in': logged_in}
        return redirect("http://localhost:3000/")


@app.route('/loanform', methods=['POST', 'GET'])
def loan_form():
    if request.method == 'POST':
        # name = request.form['name']
        # username = request.form['username']
        # password = request.form['password']
        # await database.connect_db()
        # await client_factory.create_client(name, username, password)
        return redirect("http://localhost:3000/clientstatus")
    return {'message': 'Successfully registered!'}


@app.route('/flask_logout')
def logout():
    # return {'message': 'Successfully logged out!', 'logged_in': False}
    return redirect("http://localhost:3000/login")


@app.route('/clientstatus')
async def clientstatus():
    await database.connect_db()
    from models.ClientModel import ClientModel
    from models.LoanFormModel import LoanFormModel
    from models.TransactionModel import TransactionModel
    client = await ClientModel.query.where(ClientModel.bank_id == 79706556).gino.first()
    loan_details = await LoanFormModel.query.where(LoanFormModel.loan_id == client.loan_id).gino.first()
    transactions = await TransactionModel.query.where(TransactionModel.client_id == client.bank_id).gino.all()
    await database.disconnect_db()

    client = {'name': client.name,
              'bank_id': client.bank_id,
              'loan_id': client.loan_id}

    client_data = {'client': client}

    print(client_data)

    print("**********************\n\n\n")
    return {'message': 'Success', 'client_data': client_data}


# TODO: Need this in a thread to run periodically
# manager.set_command(send_payment_reminder)
# manager.command.execute()
if __name__ == "__main__":
    app.run(host='0.0.0.0', port=81)
