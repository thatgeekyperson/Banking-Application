public class DetailWashingDecorator extends WashingDecorator{
    DetailWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + vehicle.getClassName() + " " + vehicle.getLicensePlate() + " Detailed. ";
    }
}
