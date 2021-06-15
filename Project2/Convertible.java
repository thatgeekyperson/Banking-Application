public class Convertible extends Car {
    static int counter = 0;

    Convertible() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
