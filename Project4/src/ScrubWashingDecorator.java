public class ScrubWashingDecorator extends WashingDecorator{
    ScrubWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public void shines() {
        super.shines();
        System.out.print(vehicle.getClassName() + " " + vehicle.getLicensePlate() + " Scrubbed. ");
    }
}
