public class TruckFactory extends VehicleFactory{

    @Override
    public Vehicle getVehicle(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("Pickup")) {
            return new Pickup(new VehicleUnlockStrategy());
        } else if (vehicleType.equalsIgnoreCase("Delivery")) {
            return new Delivery(new VehicleUnlockStrategy());
        } else if (vehicleType.equalsIgnoreCase("Monster")) {
            return new Monster(new VehicleUnlockStrategy());
        }
        return null;
    }
}
