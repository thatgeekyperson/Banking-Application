import java.util.Random;

public class Car extends Vehicle {

    @Override
    public void runs() {
        Random random = new Random();
        int randomInt = random.nextInt(100);
        if (randomInt > 25) {
            super.runs();
        } else {
            System.out.println(this.getClass().getName() + " " + super.getLicensePlate() + " sputters.");
        }
    }
}
