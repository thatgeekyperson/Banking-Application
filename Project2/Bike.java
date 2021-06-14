import java.util.Random;

public class Bike extends Motorcycle {
    static int counter = 0;

    Bike() {
        super.licensePlate = super.initLicensePlate(counter++);
    }

    @Override
    public void unlocked() {
        Random random = new Random();
        int randomInt = random.nextInt(100);
        if (randomInt > 25) {
            super.unlocked();
        } else {
            System.out.println(this.getClass().getName() + " " + super.getLicensePlate() + " unlocked override.");
        }
    }
}
