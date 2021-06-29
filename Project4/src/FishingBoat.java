public class FishingBoat extends Boat {
    //FishingBoat is inheriting the class Boat

    static int counter = 0;
    FishingBoat(UnlockStrategy unlockStrategy) {
        super(unlockStrategy);
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
