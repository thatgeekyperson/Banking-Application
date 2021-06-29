import java.util.List;

public class WashCommand implements Command{

    Mechanic mechanic;
    List<Vehicle> vehicleList;

    public WashCommand(Mechanic mechanic, List<Vehicle> vehicleList) {
        this.mechanic = mechanic;
        this.vehicleList = vehicleList;
    }

    @Override
    public void execute() {
        for(Vehicle v: this.vehicleList) {
            mechanic.wash(v);
            System.out.println(v.getClass().getName() + " " + v.getLicensePlate() + " " + v.shines() + ".");
        }

    }

    @Override
    public void undo() {
        //
        return;
    }
}
