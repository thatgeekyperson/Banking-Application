public class CarFactory extends VehicleFactory{

    @Override
    public Vehicle getVehicle(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("Convertible")) {
            return new Convertible(new VehicleUnlockStrategy());
        } else if (vehicleType.equalsIgnoreCase("HatchBack")) {
            return new Hatchback(new VehicleUnlockStrategy());
        } else if (vehicleType.equalsIgnoreCase("Wagon")) {
            return new Wagon(new VehicleUnlockStrategy());
        } else if (vehicleType.equalsIgnoreCase("SUV")) {
            return new SUV(new VehicleUnlockStrategy());
        }
        return null;
    }
}
