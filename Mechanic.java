public class Mechanic extends GarageEmployee {
    String name;

    Mechanic(String name) {
        this.name = name;
    }

    public void unlock(Vehicle v) {
        // https://stackoverflow.com/questions/6271417/java-get-the-current-class-name
        System.out.println("Mechanic " + this.name + " unlocks " + v.getClass().getName() + " " + v.getLicensePlate());
    }

    public void wash(Vehicle v) {

    }

    public void tuneUp(Vehicle v) {

    }

    public void testDrive(Vehicle v) {

    }

    public void lockUp(Vehicle v) {

    }
}
