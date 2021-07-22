from flask import Flask, request, redirect, url_for
from flask_cors import CORS
import pickle
from sqlalchemy import and_

import database
from Bank import Bank
from ClientFactory import ClientFactory
from Manager import Manager
from SendPaymentReminder import SendPaymentReminder

app = Flask(__name__)
CORS(app)

bank = Bank()
client_factory = ClientFactory(bank)


@app.route('/', methods=['POST', 'GET'])
def index():
    if request.method == 'POST':
        return redirect("http://localhost:3000/clientstatus")
    return {'heading': 'Welcome to the App'}


@app.route('/register', methods=['POST', 'GET'])
async def register():
    if request.method == 'POST':
        name = request.form['name']
        username = request.form['username']
        password = request.form['password']
        await database.connect_db()
        client = await client_factory.create_client(name, username, password)
        bank.add_client(client)
        return redirect("http://localhost:3000/login")
    if request.method == 'GET':
        return redirect("http://localhost:3000/register")


@app.route('/login', methods=['POST', 'GET'])
async def login():
    if request.method == 'POST':
        # TODO: login logic
        username = request.json['username']
        password = request.json['password']
        await database.connect_db()
        from models.ClientModel import ClientModel
        client = await ClientModel.query.where(and_(ClientModel.username == username,
                                                    ClientModel.password == password)).gino.first()
        await database.disconnect_db()
        if client:
            return {'message': 'Successfully logged in!', 'logged_in': True, 'client_id': client.bank_id}
        else:
            return {'message': 'Unsuccessful log in!', 'logged_in': False, 'client_id': None}
    if request.method == 'GET':
        return redirect("http://localhost:3000/login")


@app.route('/loanform', methods=['POST', 'GET'])
async def loan_form():
    if request.method == 'POST':
        g1 = int(request.form['gender'])
        m1 = int(request.form['married'])
        se1 = int(request.form['self_employed'])
        ed1 = int(request.form['education'])
        ch1 = int(request.form['credit_history'])
        pa1 = int(request.form['prop_area'])
        await database.connect_db()
        from models.ClientModel import ClientModel
        client = await ClientModel.query.gino.first()  # TODO: need to change
        from LoanFormFactory import LoanFormFactory

        from Predictor import Predictor
        prediction = Predictor.predict([[g1, m1, se1, ed1, ch1, pa1]])
        if prediction == 0:
            print("Loan rejected")
        else:
            print("Loan approved")

        loan_term = 0 if (prediction == 0) else int(request.form['loan_term'])
        print(loan_term)
        await LoanFormFactory.create_loan_form(g1, m1, se1, ed1, ch1, pa1, int(request.form['loan_amount']),
                                               loan_term, client)
        await database.disconnect_db()
    return redirect("http://localhost:5000/clientstatus?prediction="+str(prediction))
    # return {'message': 'Successfully registered!'}


# @app.route('/flask_logout')
# def logout():
#     # return {'message': 'Successfully logged out!', 'logged_in': False}
#     return redirect("http://localhost:3000/login")


@app.route('/clientstatus', methods=['POST'])
async def clientstatus():
    await database.connect_db()
    from models.ClientModel import ClientModel
    from models.LoanFormModel import LoanFormModel
    from models.TransactionModel import TransactionModel
    # client = await ClientModel.query.where(ClientModel.bank_id == 3659022).gino.first()
    print("\n\n")
    print(request.json)
    print("\n\n")
    client = await ClientModel.query.where(ClientModel.bank_id == int(request.json['clientId'])).gino.first()
    loan_details = None
    if client:
        loan_details = await LoanFormModel.query.where(LoanFormModel.loan_id == client.loan_id).gino.first()
    else:
        print("No client")
    transactions = None
    if loan_details:
        transactions = await TransactionModel.query.where(TransactionModel.client_id == client.bank_id).gino.all()
    else:
        print("No loan details")
    await database.disconnect_db()

    client = {
        'name': client.name,
        'bank_id': client.bank_id,
        'loan_id': client.loan_id
    }
    loan_details = {
        'loan_amount': loan_details.loan_amount,
        'loan_term_months': loan_details.loan_term_months,
        'loan_amount_remaining': loan_details.loan_amount_remaining
    }

    if loan_details['loan_term_months'] == 0:
        return {'message': 'Loan rejected', 'client_data':
            {'client': client, 'loan_details': loan_details, 'transactions': None}}

    transaction_json = dict()
    index = 0
    for trans in transactions:
        transaction_json[index] = {
            'transaction_id': trans.transaction_id,
            'client_id': trans.client_id,
            'amount_paid': trans.amount_paid
        }
        index += 1

    client_data = {'client': client, 'loan_details': loan_details, 'transactions': transaction_json}

    print(client_data)

    print("**********************\n\n\n")
    return {'message': 'Success', 'client_data': client_data}


# TODO: Need this in a thread to run periodically

if __name__ == "__main__":
    send_payment_reminder = SendPaymentReminder(bank)
    manager = Manager.instance()
    manager.set_command(send_payment_reminder)
    manager.command.execute()
    app.run(host='0.0.0.0', port=81)
