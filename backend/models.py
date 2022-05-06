from datetime import datetime
from re import L
from sre_constants import CATEGORY_UNI_DIGIT
from unicodedata import name
from flask_login import UserMixin

if __name__ == "__main__":
    from flask import Flask
    from flask_sqlalchemy import SQLAlchemy
    from config import Config

    current_app = Flask(__name__)
    current_app.config.from_object(Config)
    db = SQLAlchemy(current_app)

else:
    from flask import Flask
    from flask_sqlalchemy import SQLAlchemy
    from .config import Config
    from flask import current_app
    db = SQLAlchemy(current_app)

# @login_manager.user_loader
# def load_user(user_id):
#     return User.query.get(int(user_id))

class Category(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(60), nullable=False)

class Expense(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    project_id = db.Column(db.Integer, nullable=False)
    category_id = db.Column(db.Integer, nullable=False)
    name = db.Column(db.String(60), nullable=False)
    description = db.Column(db.String(100), nullable=False)
    amount = db.Column(db.Integer, nullable=False)
    created_at = db.Column(db.DateTime, nullable=False)
    created_by = db.Column(db.String(60), nullable=False)
    updated_at = db.Column(db.DateTime, nullable=False)
    updated_by = db.Column(db.String(60), nullable=False)

class Project(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    user_id = db.Column(db.Integer, nullable=False)
    name = db.Column(db.String(60), nullable=False)
    budget = db.Column(db.Integer, nullable=False)
    description = db.Column(db.String(100), nullable=False)

class User(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(100), unique=True, nullable=False)
    password = db.Column(db.String(60), nullable=False)
    name = db.Column(db.String(60), nullable=False)
    appointment = db.Column(db.String(60), nullable=False)

if __name__ == "__main__":
    db.create_all()