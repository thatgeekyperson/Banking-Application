public class DryWashingDecorator extends WashingDecorator{
    DryWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + vehicle.getClassName() + " " + vehicle.getLicensePlate() + " Dried. ";
    }
}
