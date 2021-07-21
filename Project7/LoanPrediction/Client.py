import random
from abc import ABC
from LoanForm import LoanForm
from Observer import Observer
from Subject import Subject


class Client(Subject, ABC):

    def __init__(self, name, username, password):
        self.name = name
        self.username = username
        self.password = password
        self.bank_id = int(random.random() * 100000000)
        self.loan_id = 0
        self.loanPredictionForm = None  # LoanPredictionForm("male", 10000, 3)

    # def set_username(self, username):
    #     pass
    #
    # def set_password(self, password):
    #     pass

    def update(self) -> None:
        print(self.name + " is sending payment to bank of amount " +
              str(self.loanPredictionForm.loan_amount/self.loanPredictionForm.loan_term_months))
        pass

    def __str__(self):
        return str(self.bank_id) + " " + str(self.name) + " " + str(self.loan_id) \
               + " " + str(self.username) + " " + str(self.password)
