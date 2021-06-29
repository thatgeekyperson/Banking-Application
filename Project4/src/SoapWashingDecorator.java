public class SoapWashingDecorator extends WashingDecorator{

    Mechanic mechanic;


    SoapWashingDecorator(String name, Mechanic mechanic) {
        super(name);
        this.mechanic = mechanic;
    }

    @Override
    public void wash(Vehicle v) {
        this.mechanic.wash(v);
        System.out.print(v.getClass().getName() + " " + v.getLicensePlate() + "Soaped. ");
    }
}
