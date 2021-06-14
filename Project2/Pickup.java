public class Pickup extends Truck {
    static int counter = 0;

    Pickup() {
        super.licensePlate = super.initLicensePlate(counter++);
    }
}
