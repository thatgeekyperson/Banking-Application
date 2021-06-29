public class PolishWashingDecorator extends WashingDecorator{
    PolishWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public void shines() {
        super.shines();
        System.out.print(vehicle.getClassName() + " " + vehicle.getLicensePlate() + " Polished. ");
    }
}
