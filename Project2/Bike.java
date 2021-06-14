import java.util.Random;

public class Bike extends Motorcycle {
    static int counter = 0;

    Bike() {
        super.licensePlate = super.initLicensePlate(counter++);
    }

}
