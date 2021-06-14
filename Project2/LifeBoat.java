public class LifeBoat extends Boat {
    static int counter = 0;

    LifeBoat() {
        super.licensePlate = super.initLicensePlate(counter++);
    }
}
