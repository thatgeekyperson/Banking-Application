public class MotercycleFactory extends VehicleFactory{

    @Override
    public Vehicle getVehicle(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("Bike")) {
            return new Bike(new VehicleUnlockStrategy());
        } else if (vehicleType.equalsIgnoreCase("Trike")) {
            return new Trike(new VehicleUnlockStrategy());
        } else if (vehicleType.equalsIgnoreCase("Sidecar")) {
            return new Sidecar(new VehicleUnlockStrategy());
        }
        return null;
    }
}
