from flask import Flask, render_template, request, redirect, url_for, flash, jsonify
from flask_restful import Api, Resource, fields
from flask_cors import CORS
from flask_login import login_user, logout_user, current_user
from backend.apiHandler import ApiHandler
# from .models import User, db
# import resources

app = Flask(__name__, static_url_path='', static_folder='./src/john-components')
api = Api(app)

@app.route('/expense', methods = ['GET','POST'])
def expense():
    jsonlist = [{
        "id": 1,
        "projectId": 2,
        "categoryId": 2,
        "name": "Server Maintenance",
        "description": "Server maintenance and upgrading work to incorporate BC plans",
        "amount": 30000,
        "createdAt": "2021-11-04T16:00:00.000Z",
        "createdBy": "Jacky",
        "updatedAt": "2021-11-06T16:00:00.000Z",
        "updatedBy": "Jacky"
    },
    {
        "id": 2,
        "projectId": 3,
        "categoryId": 4,
        "name": "Consultant",
        "description": "Consultancy services for integration work",
        "amount": 10000,
        "createdAt": "2021-11-06T16:00:00.000Z",
        "createdBy": "Helen",
        "updatedAt": "2021-11-07T16:00:00.000Z",
        "updatedBy": "Helen"
    }]
    # return redirect("www.google.com")
    return jsonify(jsonlist)
    # return redirect('/login')

api.add_resource(ApiHandler, '/expense')

if __name__ == "__main__":
    app.run(debug=True)