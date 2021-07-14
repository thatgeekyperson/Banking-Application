from Client import Client


class ClientFactory:

    @staticmethod
    async def create_client(name):
        client = Client(name)
        from ClientModel import ClientModel
        await ClientModel.create(bank_id=client.bankID, name=client.name)
        return client
