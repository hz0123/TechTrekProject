from flask import Flask

app = Flask(__name__)

@app.route('/login')
def login():
    response_body = {
        "email": "admin@admin.com",
        "password": "admin123"
    }
    return response_body

if __name__ == "__main__":
    app.run(debug=True)
# @auth.route("/login", methods=["GET", "POST"])
# def login():
#     if current_user.is_authenticated:
#         return redirect(url_for("admin.index")) if current_user.admin() else redirect(url_for("user.index"))
#     form = LoginForm()
#     if form.validate_on_submit():
#         user = User.query.filter_by(email=form.email.data).first()
#         password = User.query.filter_by(password=form.password.data).first()
#         # if user and check_password_hash(user.password, form.password.data):
#         if user == "test@dbs.com" and password == "password":
#             flash("Login successful!", "success")
#             next_page = request.args.get("next")
#             if next_page:
#                 return redirect(next_page)
#             else:
#                 return redirect(url_for("user.index"))
#         else:
#             flash("Invalid login. Please try again.", "danger")
#     return render_template("login.html", title="Login", form=form)

