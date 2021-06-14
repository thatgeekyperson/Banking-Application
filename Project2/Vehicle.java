import java.util.Random;

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
        Random random = new Random();
        int randomInt = random.nextInt(100);
        if (randomInt > 30) {
            System.out.println(this.getClass().getName() + " " + this.getLicensePlate() + " shines.");
        } else {
            System.out.println(this.getClass().getName() + " " + this.getLicensePlate() + " sparkles.");
        }
    }

    public void runs() {
        System.out.println(this.getClass().getName() + " " + this.licensePlate + " runs.");
    }

    public String drives() {
        return "drives";
    }

    public void locked() {
        System.out.println(this.getClass().getName() + " " + this.licensePlate + " locked.");
    }
}

