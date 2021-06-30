public class ScrubWashingDecorator extends WashingDecorator{
    ScrubWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + vehicle.getClassName() + " " + vehicle.getLicensePlate() + " Scrubbed. ";
    }
}
