import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Mechanic extends GarageEmployee implements PropertyChangeListener{
    // Mechanic is an observer for garageClock and an observable for garageAnnouncer.
    // https://www.baeldung.com/java-observer-pattern
    // https://docs.oracle.com/javase/tutorial/uiswing/events/propertychangelistener.html
    // Mechanic is inheriting the GarageEmployee abstract class

    private String state;
    private PropertyChangeSupport support;
    private Integer time;

    Mechanic(String name) {
        super(name);
        setTime(8);
        support = new PropertyChangeSupport(this);
    }

    public String getState() {
        return state;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName() == "time") {
            Integer time = (Integer) evt.getNewValue();
            System.out.println("Mechanic: The current time is " + time + "00.");
            this.setTime(time == 20 ? 8 : time);
        }
    }

    public void setState(String state) throws InterruptedException {
        if (state == "unlock") {
            while(this.getTime() < 10) {
//                System.out.println("Waiting here 10 ...");
                Thread.sleep(100);
                continue;
            }
        } else if (state == "wash") {
            while(this.getTime() < 12) {
//                System.out.println("Waiting here 12 ...");
                Thread.sleep(100);
                continue;
            }
        } else if (state == "tune up") {
            while(this.getTime() < 14) {
//                System.out.println("Waiting here 14 ...");
                Thread.sleep(100);
                continue;
            }
        } else if (state == "drive") {
            while(this.getTime() < 16) {
//                System.out.println("Waiting here 16 ...");
                Thread.sleep(100);
                continue;
            }
        } else if (state == "lock up") {
            while(this.getTime() < 18) {
//                System.out.println("Waiting here 18 ...");
                Thread.sleep(100);
                continue;
            }
        }
        support.firePropertyChange("state", this.state, state);
        this.state = state;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
