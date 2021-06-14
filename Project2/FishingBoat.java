public class FishingBoat extends Boat {
    static int counter = 0;

    FishingBoat() {
        super.licensePlate = super.initLicensePlate(counter++);
    }
}
