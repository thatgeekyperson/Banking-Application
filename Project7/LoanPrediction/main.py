from Bank import Bank
from ClientFactory import ClientFactory
from LoanForm import LoanForm
from Manager import Manager
import database
import asyncio

from SendPaymentReminder import SendPaymentReminder


async def print_name_list(model):
    name_list = await model.query.gino.all()
    print("\n\n************************************\n")
    for entry in name_list:
        print(entry)
    print("\n************************************\n\n")


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
                                                                'loan_amount INT, loan_amount_remaining INT, '
                                                                'loan_term_months INT);'))
        await db_loan_prediction.status(db_loan_prediction.text('drop table transactions;'))
        await db_loan_prediction.status(db_loan_prediction.text('create TABLE transactions '
                                                                '(transaction_id INT PRIMARY KEY, client_id INT, '
                                                                'amount_paid INT);'))
        # await db_loan_prediction.status(db_loan_prediction.text('insert into client values (10001, \'Manan\', 0, '
        #                                                         '\'manankh\', \'qwerty\');'))

        from LoanFormFactory import LoanFormFactory
        client1 = await client_factory.create_client("Tava", "tpr", "poe67")
        await LoanFormFactory.create_loan_form("F", 9000, 30, client1)
        client2 = await client_factory.create_client("Mana", "mana", "man67")
        await LoanFormFactory.create_loan_form("M", 12000, 20, client2)
        client3 = await client_factory.create_client("Bruce", "bru", "bru67")
        await LoanFormFactory.create_loan_form("M", 8000, 32, client3)

    await query()

    from models.ClientModel import ClientModel
    await print_name_list(ClientModel)

    from models.LoanFormModel import LoanFormModel
    await print_name_list(LoanFormModel)

    manager.set_command(send_payment_reminder)
    await manager.command.execute()

    from models.TransactionModel import TransactionModel
    await print_name_list(TransactionModel)


if __name__ == '__main__':
    asyncio.run(serve())
