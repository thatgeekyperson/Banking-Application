public abstract class GarageEmployee {
    //Abstract class: methods are defined here and can be extended in subclass

    // Identity of Mechanic
    private String name;

    GarageEmployee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void unlock(Vehicle v) {
        // https://stackoverflow.com/questions/6271417/java-get-the-current-class-name
        System.out.println(this.getClass().getName() + " " + this.getName() + " unlocks " + v.getClass().getName() + " " + v.getLicensePlate() + ".");
    }

    public void wash(Vehicle v) {
        System.out.println(this.getClass().getName() + " " + this.getName() + " washes " + v.getClass().getName() + " " + v.getLicensePlate() + ".");
    }

    public void tuneUp(Vehicle v) {
        System.out.println(this.getClass().getName() + " " + this.getName() + " tunes up " + v.getClass().getName() + " " + v.getLicensePlate() + ".");
    }

    public void testDrive(Vehicle v) {
        System.out.println(this.getClass().getName() + " " + this.getName() + " test drives " + v.getClass().getName() + " " + v.getLicensePlate() + ".");
    }

    public void lockUp(Vehicle v) {
        System.out.println(this.getClass().getName() + " " + this.getName() + " locks up " + v.getClass().getName() + " " + v.getLicensePlate() + ".");
    }
}
