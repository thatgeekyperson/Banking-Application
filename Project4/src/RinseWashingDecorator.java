public class RinseWashingDecorator extends WashingDecorator{
    RinseWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + vehicle.getClassName() + " " + vehicle.getLicensePlate() + " Rinsed. ";
    }
}
