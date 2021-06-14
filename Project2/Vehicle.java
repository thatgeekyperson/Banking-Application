public class Vehicle {

    protected String licensePlate;

    public String getLicensePlate() {
        return licensePlate;
    }

    public String initLicensePlate(int counter) {
        // https://stackoverflow.com/questions/17696946/how-to-format-a-3-digit-integer-to-a-4-digit-string
        return this.getClass().getName().toCharArray()[0]+String.format("%05d", counter);
    }

    public void unlocked() {
        System.out.println(this.getClass().getName() + " " + this.licensePlate + " unlocked.");
    }

    public void shines() {
        System.out.println(this.getClass().getName() + " " + this.licensePlate + " shines.");
    }

    public void runs() {
        System.out.println(this.getClass().getName() + " " + this.licensePlate + " runs.");
    }

    public void drives() {
        System.out.println(this.getClass().getName() + " " + this.licensePlate + " drives.");
    }

    public void locked() {
        System.out.println(this.getClass().getName() + " " + this.licensePlate + " locked.");
    }
}

