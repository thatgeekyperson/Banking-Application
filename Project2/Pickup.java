public class Pickup extends Truck {
    static int counter = 0;

    Pickup() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
