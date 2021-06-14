public class Hatchback extends Car {
    static int counter = 0;

    Hatchback() {
        super.licensePlate = super.initLicensePlate(counter++);
    }
}
