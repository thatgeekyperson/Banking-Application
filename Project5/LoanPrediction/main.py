from Client import Client
from ClientFactory import ClientFactory
from Manager import Manager
import database
import asyncio
from time import sleep


async def serve() -> None:
    await database.connect_db()

    from database import db_loan_prediction

    client1 = await ClientFactory.create_client("Tav")
    manager = Manager.instance()

    print(Manager.instance() == manager)
    print(client1.name, client1.bankID)

    sleep(1)

    async def query():
        from ClientModel import ClientModel
        # name_list = await db_loan_prediction.status(db_loan_prediction.text('select * from student'))
        name_list = await ClientModel.query.gino.all()
        for entry in name_list:
            print(entry)

    await query()

if __name__ == '__main__':
    asyncio.run(serve())
