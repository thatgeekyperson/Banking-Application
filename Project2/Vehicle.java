import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vehicle {

    String licensePlate;

    public String getLicensePlate() {
        return licensePlate;
    }

    protected String initLicensePlate(int counter) {
        // https://stackoverflow.com/questions/17696946/how-to-format-a-3-digit-integer-to-a-4-digit-string
        return this.getClass().getName().toCharArray()[0]+String.format("%05d", counter);
    }

    public void unlocked() {
        System.out.println(this.getClass().getName() + " " + this.licensePlate + " unlocked.");
    }

    public void shines() {

    }

    public void runs() {

    }

    public void drives() {

    }

    public void locked() {

    }
}

class Bike extends Motorcycle {
    static int counter = 0;
    Bike() {
        licensePlate = this.initLicensePlate(counter++);
    }

    @Override
    public String toString() {
        return "Bike license plate is: "+licensePlate;
    }

    @Override
    public void unlocked() {
        Random random = new Random();
        int randomInt = random.nextInt(100);
        if(randomInt > 25) {
            super.unlocked();
        } else {
            System.out.println(this.getClass().getName() + " " + this.licensePlate + " unlocked override.");
        }
    }
}

class Trike extends Motorcycle {

}

class Sidecar extends Motorcycle {

}

class Hatchback extends Car {

}

class SUV extends Car {

}

class Wagon extends Car {

}

class Convertible extends Car {

}

class Pickup extends Truck {

}

class Delivery extends Truck {

}

class Monster extends Truck {

}

class LifeBoat extends Boat {

}

class FishingBoat extends Boat {

}

class Garage {

    public static void main(String[] args) {

        // TODO: take input
        int numberOfDays = 2;

        Mechanic m1 = new Mechanic("Marco");

        Bike b1 = new Bike();
        Bike b2 = new Bike();
        LifeBoat l1 = new LifeBoat();

        List<Vehicle> vehiclesInGarage = new ArrayList();
        vehiclesInGarage.add(b1);
        vehiclesInGarage.add(b2);
        vehiclesInGarage.add(l1);

        for(int counter = 0; counter < numberOfDays; counter++) {
            System.out.println("Day " + (counter+1));
            for(Vehicle v : vehiclesInGarage) {
                m1.unlock(v);
                v.unlocked();
            }
            System.out.println();
        }

    }
}