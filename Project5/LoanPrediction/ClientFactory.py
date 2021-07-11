from Client import Client


class ClientFactory:

    @staticmethod
    def create_client(name):
        return Client(name)
