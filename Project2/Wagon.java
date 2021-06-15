public class Wagon extends Car {
    static int counter = 0;

    Wagon() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
