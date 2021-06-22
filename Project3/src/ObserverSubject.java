public interface ObserverSubject {

    public void registerObserver(Observer observer);

    public void removeObserver();

    public void notifyObserver();

}
