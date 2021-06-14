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
        System.out.println("Mechanic " + this.name + " washes " + v.getClass().getName() + " " + v.getLicensePlate());
    }

    public void tuneUp(Vehicle v) {
        System.out.println("Mechanic " + this.name + " tunes up " + v.getClass().getName() + " " + v.getLicensePlate());
    }

    public void testDrive(Vehicle v) {
        System.out.println("Mechanic " + this.name + " test drives " + v.getClass().getName() + " " + v.getLicensePlate());
    }

    public void lockUp(Vehicle v) {
        System.out.println("Mechanic " + this.name + " locks up " + v.getClass().getName() + " " + v.getLicensePlate());
    }
}
