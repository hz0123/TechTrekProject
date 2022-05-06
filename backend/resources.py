from flask_restful import Resource, reqparse
import hashlib
from models import User, db

parser = reqparse.RequestParser()
parser.add_argument('username', help = 'Username cannot be blank', required = True)
parser.add_argument('password', help = 'Password cannot be blank', required = True)


class UserLogin(Resource):
    def post(self):
        try:
            data = parser.parse_args()
            current_user = User.query.filter(User.username==data['username']).first()

            if not current_user:
                return {"error":"User not in DB. Register as a new user"}

            password = hashlib.md5(data['password'].encode()).hexdigest()
            if current_user.password == password :
                return {
                    'username': current_user.username,
                }
            else:
                return {'error': 'Wrong credentials'}
        except:
            raise Exception("Cannot login user")