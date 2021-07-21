import asyncio
from time import sleep
from flask import Flask, request, redirect, url_for
from flask_cors import CORS
import database

# asyncio.run()
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
    if request.method == 'GET':
        # message = "You are registered %s" % name
        return {'message': 'Successfully registered!', 'logged_in': True}
    return {'message': 'Successfully registered!'}


@app.route('/loan_form', methods=['POST', 'GET'])
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
    return redirect("http://localhost:3000/login")

# TODO: Need this in a thread to run periodically
# manager.set_command(send_payment_reminder)
# manager.command.execute()
if __name__ == "__main__":
    app.run(host='0.0.0.0', port=81)
