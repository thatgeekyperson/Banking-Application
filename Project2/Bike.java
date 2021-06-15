import java.util.Random;

public class Bike extends Motorcycle {
    static int counter = 0;

    Bike() {
        //Abstraction: initLicensePlate implementation details are hidden
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
