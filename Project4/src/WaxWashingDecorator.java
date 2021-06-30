public class WaxWashingDecorator extends WashingDecorator{
    WaxWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + vehicle.getClassName() + " " + vehicle.getLicensePlate() + " Waxed. ";
    }
}
