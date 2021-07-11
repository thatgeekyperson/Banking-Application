from abc import ABC, abstractmethod
from Client import Client


class Observer(ABC):
    """
    The Observer interface declares the update method, used by subjects.
    """

    @abstractmethod
    def update(self, client: Client) -> None:
        """
        Receive update from subject.
        """
        pass
