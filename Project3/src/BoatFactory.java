public class BoatFactory extends VehicleFactory{

    @Override
    public Vehicle getVehicle(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("FishingBoat")) {
            return new FishingBoat(new VehicleUnlockStrategy());
        } else if (vehicleType.equalsIgnoreCase("LifeBoat")) {
            return new LifeBoat(new VehicleUnlockStrategy());
        }
        return null;
    }
}
