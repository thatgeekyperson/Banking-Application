from Manager import Manager
from Observer import Observer


class Bank(Observer):
    client_list = []
    manager = Manager.instance()

    def notify(self) -> None:
        if self.client_list:
            for client in self.client_list:
                client.update()
        print("Updated clients")

    def add_client(self, client):
        self.client_list.append(client)

    def remove_client(self, client):
        self.client_list.remove(client)
