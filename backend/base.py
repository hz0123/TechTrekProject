from flask import Flask

api = Flask(__name__)

@api.route('/login')

def login():
    response_body = {
        "email": "admin@admin.com",
        "password": "admin123"
    }
    return response_body