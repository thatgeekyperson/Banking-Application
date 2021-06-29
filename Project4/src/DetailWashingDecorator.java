public class DetailWashingDecorator extends WashingDecorator{
    DetailWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public void shines() {
        super.shines();
        System.out.print(vehicle.getClassName() + " " + vehicle.getLicensePlate() + " Detailed. ");
    }
}
