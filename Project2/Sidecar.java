public class Sidecar extends Motorcycle {
    static int counter = 0;

    Sidecar() {
        super.licensePlate = super.initLicensePlate(counter++);
    }
}
