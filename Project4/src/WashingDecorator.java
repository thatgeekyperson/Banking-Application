public class WashingDecorator extends Mechanic {

    Mechanic mechanic;

    WashingDecorator(String name, Mechanic mechanic) {
        super(name);
        this.mechanic = mechanic;
    }

}
