public class Sidecar extends Motorcycle {
    static int counter = 0;

    Sidecar() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
