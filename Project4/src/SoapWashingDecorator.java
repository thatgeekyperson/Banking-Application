public class SoapWashingDecorator extends WashingDecorator{

    SoapWashingDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public String shines() {
        return getVehicle().getClassName() + " " + getVehicle().getLicensePlate() + " Soaped. ";
    }

}
