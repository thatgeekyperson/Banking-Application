import java.util.List;

public class UnlockCommand implements Command{

    Mechanic mechanic;
    List<Vehicle> vehicleList;

    public UnlockCommand(Mechanic mechanic, List<Vehicle> vehicleList) {
        this.mechanic = mechanic;
        this.vehicleList = vehicleList;
    }

    @Override
    public void execute() {
        for(Vehicle v: this.vehicleList) {
            mechanic.unlock(v);
            System.out.println(v.getClass().getName() + " " + v.getLicensePlate() + " " + v.unlocked() + ".");
        }

    }

    @Override
    public void undo() {
        //
        return;
    }
}
