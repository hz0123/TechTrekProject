from flask import Flask, render_template, request, redirect, url_for, flash, jsonify
from flask_restful import Api, Resource, fields
from flask_login import login_user, logout_user, current_user
# from .models import User, db
# import resources

app = Flask(__name__)

@app.route('/expense')
def expense():
    jsonlist = [{
        "id": 1,
        "project_id": 2,
        "category_id": 2,
        "name": "Server Maintenance",
        "description": "Server maintenance and upgrading work to incorporate BC plans",
        "amount": 30000,
        "created_at": "2021-11-04T16:00:00.000Z",
        "created_by": "Jacky",
        "updated_at": "2021-11-06T16:00:00.000Z",
        "updated_by": "Jacky"
    },
    {
        "id": 2,
        "project_id": 3,
        "category_id": 4,
        "name": "Consultant",
        "description": "Consultancy services for integration work",
        "amount": 10000,
        "created_at": "2021-11-06T16:00:00.000Z",
        "created_by": "Helen",
        "updated_at": "2021-11-07T16:00:00.000Z",
        "updated_by": "Helen"
    }]
    return jsonify(jsonlist)

@app.route('/add', methods = ["POST"])
def add():
    # name = request.json['name']
    db.session

if __name__ == "__main__":
    app.run(debug=True)