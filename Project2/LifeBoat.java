public class LifeBoat extends Boat {
    static int counter = 0;

    LifeBoat() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
