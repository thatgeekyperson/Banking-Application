public class Delivery extends Truck {
    static int counter = 0;

    Delivery() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
