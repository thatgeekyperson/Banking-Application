public class Delivery extends Truck {
    static int counter = 0;

    Delivery() {
        super.licensePlate = super.initLicensePlate(counter++);
    }
}
