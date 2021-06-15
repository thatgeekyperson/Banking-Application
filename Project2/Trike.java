public class Trike extends Motorcycle {
    static int counter = 0;

    Trike() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
