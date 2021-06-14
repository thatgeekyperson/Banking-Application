public class Monster extends Truck {
    static int counter = 0;

    Monster() {
        super.licensePlate = super.initLicensePlate(counter++);
    }
}
