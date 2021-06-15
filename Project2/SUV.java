public class SUV extends Car {
    static int counter = 50000;

    SUV() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
