import asyncio
from time import sleep
from flask import Flask, request, redirect, url_for
from flask_cors import CORS
import database

# asyncio.run()
app = Flask(__name__)
CORS(app)


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
        sleep(1)
        from ClientFactory import ClientFactory
        client = await ClientFactory.create_client(name, username, password)
        return redirect("http://localhost:3000/login")
    if request.method == 'GET':
        return redirect("http://localhost:3000/register")


@app.route('/login', methods=['POST', 'GET'])
def login():
    if request.method == 'GET':
        # message = "You are registered %s" % name
        return {'message': 'Successfully registered!'}
    return {'message': 'Successfully registered!'}


app.run(host='0.0.0.0', port=81)
