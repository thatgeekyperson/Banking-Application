public class Hatchback extends Car {
    static int counter = 0;

    Hatchback() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
