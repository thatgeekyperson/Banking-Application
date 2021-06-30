public abstract class WashingDecorator extends Vehicle {

    Vehicle vehicle;

    public WashingDecorator(Vehicle vehicle) {
        super();
        this.vehicle = vehicle;
    }

    @Override
    public String shines() {
        return vehicle.shines();
    }

    @Override
    public UnlockStrategy getUnlockStrategy() {
        return vehicle.getUnlockStrategy();
    }

    @Override
    public String unlocked() {
        return vehicle.getUnlockStrategy().unlockStrategy();
    }

    @Override
    public String getLicensePlate() {
        return vehicle.getLicensePlate();
    }

    @Override
    public String getClassName() {
        return vehicle.getClassName();
    }

}
