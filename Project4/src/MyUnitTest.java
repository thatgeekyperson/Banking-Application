import com.google.inject.matcher.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class MyUnitTest {
    VehicleFactory motorcycleFactory;
    VehicleFactory carFactory;
    VehicleFactory truckFactory;
    VehicleFactory boatFactory;


    @Before
    public void initializing(){

        motorcycleFactory = new MotorcycleFactory();
        carFactory = new CarFactory();
        truckFactory = new TruckFactory();
        boatFactory = new BoatFactory();
    }

    @Test
    @DisplayName("Runs method should return string runs")
    public void testRuns() {
        MyUnitTest myUnit = new MyUnitTest();
        Vehicle b1 = boatFactory.getVehicle("FishingBoat");
        assertEquals("runs", b1.runs());
//        testing runs() method by instantiating boat object
    }

    @Test
    @DisplayName("Monster must drive or crash")
    public void testMonster(){
        Vehicle m2 = truckFactory.getVehicle("Monster");
        String result = m2.drives();
//        testing monster crash exception
        assertTrue(result.equals("drives") || result.equals("crashes"));
    }

    @Test
    public void testCar(){
        Vehicle c1 = carFactory.getVehicle("Convertible");
        Vehicle h1 = carFactory.getVehicle("Hatchback");
        Vehicle suv1 = carFactory.getVehicle("SUV");
        Vehicle w1 = carFactory.getVehicle("Wagon");
        //Testing sputters and runs for all cars
        String r1=c1.runs();
        String r2=h1.runs();
        String r3=suv1.runs();
        String r4=w1.runs();

        assertTrue(r1.equals("sputters") || r1.equals("runs"));
        assertTrue(r2.equals("sputters") || r2.equals("runs"));
        assertTrue(r3.equals("sputters") || r3.equals("runs"));
        assertTrue(r4.equals("sputters") || r4.equals("runs"));
    }

//    @Test
//    public void testShines() {
//        Vehicle lf1 = boatFactory.getVehicle("LifeBoat");
//        String re=lf1.locked();
//        String lfclass = lf1.getClassName();
//        String lfplate = lf1.getLicensePlate();
//        String expectedResult1= lfclass + " " + lfplate + " shines. ";
//        String expectedResult2= lfclass + " " + lfplate + " sparkles. ";
//        System.out.println(re);
//        System.out.println(expectedResult1);
//        assertTrue(re.equals(expectedResult1) || re.equals(expectedResult2));
//    }

    @Test
    public void testAbstract(){
        Vehicle p1 = truckFactory.getVehicle("Pickup");
        String p1_class=p1.getClassName();

        assertTrue(p1_class.equals("Pickup"));
    }

    @Test
    public void testUserCreation(){
        String input = "Tav";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        User u1 = User.getInstance();
        assertNotNull(u1);
    }

    @Test
    public void testUserIsSingleton(){
        String input = "Tav";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        User u1 = User.getInstance();

        assertNotNull(u1);
        System.setIn(System.in);

        User u2= User.getInstance();
        assertNotNull(u2);
    }

    @Test
    public void testUserExecution(){
        String input = "Tav";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        User u1 = User.getInstance();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

//        VehicleFactory truckFactory = new TruckFactory();
//        VehicleFactory boatFactory =
        List<Vehicle> vehiclesInGarage = new ArrayList<>();
        vehiclesInGarage.add(truckFactory.getVehicle("Monster"));
        vehiclesInGarage.add(truckFactory.getVehicle("Delivery"));

        Command c=new UnlockCommand(u1, vehiclesInGarage);
        u1.setCommand(c);
        c.execute();
        String result = "Tav unlocking Monster M00000. Monster M00000 unlocked." + System.lineSeparator()+ "Tav unlocking Delivery D00000. Delivery D00000 unlocked.";
        assertEquals(result, outContent.toString().trim());
    }


    @Test
    public void testWashConvertibleDecorator(){
        //testing wash decorator for convertible
        String input = "Tav";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        User u1 = User.getInstance();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));


        List<Vehicle> vehiclesInGarage = new ArrayList<>();
        vehiclesInGarage.add(carFactory.getVehicle("Convertible"));

        Command c=new WashCommand(u1, vehiclesInGarage);
        u1.setCommand(c);
        c.execute();
        String out = outContent.toString().trim();
//        System.out.println(out);
        String expectedResultSparkles = "Tav washing Convertible C00001. Convertible C00001 Soaped. Convertible C00001 Scrubbed. Convertible C00001 Rinsed. Convertible C00001 Dried. Convertible C00001 Waxed. Convertible C00001 Detailed. Convertible C00001 Detailed. Convertible C00001 sparkles.";
        String expectedResultShines = "Tav washing Convertible C00001. Convertible C00001 Soaped. Convertible C00001 Scrubbed. Convertible C00001 Rinsed. Convertible C00001 Dried. Convertible C00001 Waxed. Convertible C00001 Detailed. Convertible C00001 Detailed. Convertible C00001 shines.";
        assertTrue(out.equals(expectedResultSparkles) || out.equals(expectedResultShines));
    }

    @Test
    public void testUserWashMonsterDecorator(){
        //testing wash decorator for monster
        String input = "Tav";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        User u1 = User.getInstance();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        Vehicle v1=truckFactory.getVehicle("Monster");
        List<Vehicle> vehiclesInGarage = new ArrayList<>();
        vehiclesInGarage.add(truckFactory.getVehicle("Monster"));


        Command c=new WashCommand(u1, vehiclesInGarage);
        u1.setCommand(c);
        c.execute();
        String out = outContent.toString().trim();
//        System.setOut(System.out);
        System.out.println(out);
        String expectedResult = "Tav washing Monster M00000. Monster M00000 Soaped. Monster M00000 Scrubbed. Monster M00000 Rinsed. Monster M00000 Dried. Monster M00000 Waxed. Monster M00000 Waxed. Monster M00000 Polished. Monster M00000 Detailed. Monster M00000 sparkles.";
        String expectedResultShines = "Tav washing Monster M00000. Monster M00000 Soaped. Monster M00000 Scrubbed. Monster M00000 Rinsed. Monster M00000 Dried. Monster M00000 Waxed. Monster M00000 Waxed. Monster M00000 Polished. Monster M00000 Detailed. Monster M00000 shines.";
        assertEquals(out, expectedResultShines);
        assertThat(out, Matchers.anyOf(Matchers.is(expectedResult),Matchers.is(expectedResultShines)));
//        assertEquals(true, out.equals(expectedResult) || out.equals(expectedResultShines));
//        assertTrue(out.equals(expectedResult) || out.equals(expectedResultShines));
    }

    @Test
    public void testLockCommand(){

        String input = "Tav";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        User u1 = User.getInstance();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));


        List<Vehicle> vehiclesInGarage = new ArrayList<>();
        vehiclesInGarage.add(motorcycleFactory.getVehicle("Bike"));

        Command c=new LockCommand(u1, vehiclesInGarage);
        u1.setCommand(c);
        c.execute();
        String out = outContent.toString().trim();

        String expectedResult= "Tav locking up Bike B00000. Bike B00000 locked.";

        assertEquals(expectedResult,outContent.toString().trim());



    }
}


