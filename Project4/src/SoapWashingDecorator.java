public class SoapWashingDecorator extends WashingDecorator{

    SoapWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public void shines() {
        System.out.print(vehicle.getClassName() + " " + vehicle.getLicensePlate() + " Soaped. ");
        super.shines();
    }

}
