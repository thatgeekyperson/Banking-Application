public class WaxWashingDecorator extends WashingDecorator{
    WaxWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + getVehicle().getClassName() + " " + getVehicle().getLicensePlate() + " Waxed. ";
    }
}
