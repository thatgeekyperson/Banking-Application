public class RinseWashingDecorator extends WashingDecorator{
    RinseWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + getVehicle().getClassName() + " " + getVehicle().getLicensePlate() + " Rinsed. ";
    }
}
