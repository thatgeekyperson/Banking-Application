public class RinseWashingDecorator extends WashingDecorator{
    RinseWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public void shines() {
        super.shines();
        System.out.print(vehicle.getClassName() + " " + vehicle.getLicensePlate() + " Rinsed. ");
    }
}
