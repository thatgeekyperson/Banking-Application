public class WaxWashingDecorator extends WashingDecorator{
    WaxWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public void shines() {
        super.shines();
        System.out.print(vehicle.getClassName() + " " + vehicle.getLicensePlate() + " Waxed. ");
    }
}
