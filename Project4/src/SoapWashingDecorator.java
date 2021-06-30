public class SoapWashingDecorator extends WashingDecorator{

    SoapWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return vehicle.getClassName() + " " + vehicle.getLicensePlate() + " Soaped. ";
    }

}
