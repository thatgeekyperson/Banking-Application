import random
from LoanPredictionForm import LoanPredictionForm


class Client:

    def __init__(self, name):
        self.name = name
        self.bankID = int(random.random() * 100000000)
        self.loanPredictionForm = LoanPredictionForm("male", 10000, 3)
