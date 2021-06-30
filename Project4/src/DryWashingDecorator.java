public class DryWashingDecorator extends WashingDecorator{
    DryWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + getVehicle().getClassName() + " " + getVehicle().getLicensePlate() + " Dried. ";
    }
}
