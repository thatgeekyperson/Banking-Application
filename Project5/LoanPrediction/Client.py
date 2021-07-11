import random
from abc import ABC
from LoanPredictionForm import LoanPredictionForm
from Observer import Observer
from Subject import Subject


class Client(Subject, ABC):

    def __init__(self, name):
        self.name = name
        self.bankID = int(random.random() * 100000000)
        self.loanPredictionForm = LoanPredictionForm("male", 10000, 3)

    def attach(self, observer: Observer) -> None:
        pass

    def detach(self, observer: Observer) -> None:
        pass

    def notify(self) -> None:
        pass
