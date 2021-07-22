from database import db_loan_prediction as db


class LoanFormModel(db.Model):
    __tablename__ = 'loan_form'

    loan_id = db.Column(db.Integer(), primary_key=True)
    gender = db.Column(db.String())
    loan_amount = db.Column(db.Integer())
    loan_term_months = db.Column(db.Integer())
    loan_amount_remaining = db.Column(db.Integer())

    def __str__(self):
        return str(self.loan_id) + " " + str(self.gender) + " " + str(self.loan_amount) \
               + " " + str(self.loan_term_months) + " " + str(self.loan_amount_remaining)
