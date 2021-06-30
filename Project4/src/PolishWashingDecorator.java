public class PolishWashingDecorator extends WashingDecorator{
    PolishWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return super.shines() + getVehicle().getClassName() + " " + getVehicle().getLicensePlate() + " Polished. ";
    }
}
