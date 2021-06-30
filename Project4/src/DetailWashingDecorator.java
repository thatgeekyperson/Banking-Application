public class DetailWashingDecorator extends WashingDecorator{
    DetailWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + getVehicle().getClassName() + " " + getVehicle().getLicensePlate() + " Detailed. ";
    }
}
