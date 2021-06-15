public class FishingBoat extends Boat {
    static int counter = 0;

    FishingBoat() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
