from Bank import Bank
from ClientFactory import ClientFactory
from LoanForm import LoanForm
from Manager import Manager
import database
import asyncio

from SendPaymentReminder import SendPaymentReminder


async def serve() -> None:
    await database.connect_db()

    bank = Bank()
    client_factory = ClientFactory(bank)

    send_payment_reminder = SendPaymentReminder(bank)
    manager = Manager.instance()

    async def query():
        from database import db_loan_prediction
        await db_loan_prediction.status(db_loan_prediction.text('drop table client;'))
        await db_loan_prediction.status(db_loan_prediction.text('create TABLE client '
                                                                '(bank_id INT PRIMARY KEY, name VARCHAR, loan_id INT, '
                                                                'username VARCHAR, password VARCHAR);'))
        await db_loan_prediction.status(db_loan_prediction.text('drop table loan_form;'))
        await db_loan_prediction.status(db_loan_prediction.text('create TABLE loan_form '
                                                                '(loan_id INT PRIMARY KEY, gender VARCHAR(1), '
                                                                'loan_amount INT, loan_term_months INT);'))
        # await db_loan_prediction.status(db_loan_prediction.text('drop table transactions;'))
        await db_loan_prediction.status(db_loan_prediction.text('create TABLE transactions '
                                                                '(transaction_id INT PRIMARY KEY, client_id INT, '
                                                                'amount INT);'))
        # await db_loan_prediction.status(db_loan_prediction.text('insert into client values (10001, \'Manan\', 0, '
        #                                                         '\'manankh\', \'qwerty\');'))

        from LoanFormFactory import LoanFormFactory
        client1 = await client_factory.create_client("Tava", "tpr", "poe67")
        await LoanFormFactory.create_loan_form("F", 9000, 30, client1)
        client2 = await client_factory.create_client("Mana", "mana", "man67")
        await LoanFormFactory.create_loan_form("M", 12000, 20, client2)
        client3 = await client_factory.create_client("Bruce", "bru", "bru67")
        await LoanFormFactory.create_loan_form("M", 8000, 32, client3)

        from models.ClientModel import ClientModel
        name_list = await ClientModel.query.gino.all()
        for entry in name_list:
            print(entry)

        from models.LoanFormModel import LoanFormModel
        name_list = await LoanFormModel.query.gino.all()
        for entry in name_list:
            print(entry)

    await query()

    manager.set_command(send_payment_reminder)
    manager.command.execute()


if __name__ == '__main__':
    asyncio.run(serve())
