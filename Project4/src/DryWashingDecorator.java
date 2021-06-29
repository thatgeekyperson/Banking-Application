public class DryWashingDecorator extends WashingDecorator{
    DryWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public void shines() {
        super.shines();
        System.out.print(vehicle.getClassName() + " " + vehicle.getLicensePlate() + " Dried. ");
    }
}
