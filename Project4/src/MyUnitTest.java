import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.junit.Test;
//import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;

public class MyUnitTest {
    @Test
    @DisplayName("Runs method should return string runs")
    public void testRuns() {
        MyUnitTest myUnit = new MyUnitTest();
//        Vehicle v =new Vehicle();
        Monster m1 = new Monster(new VehicleUnlockStrategy());
        assertEquals("runs", m1.runs());
    }

    @Test
    public void testMonster(){
        Monster m2 = new Monster(new VehicleUnlockStrategy());
        String result = m2.drives();
//        System.out.println(result);
        assertTrue(result.equals("drives") || result.equals("crashes"));
    }

    @Test
    public void testCar(){
        Convertible c1=new Convertible(new VehicleUnlockStrategy());
        Hatchback h1 = new Hatchback(new VehicleUnlockStrategy());
        SUV suv1 = new SUV(new VehicleUnlockStrategy());
        Wagon w1 = new Wagon(new VehicleUnlockStrategy());

        String r1=c1.runs();
        String r2=h1.runs();
        String r3=suv1.runs();
        String r4=w1.runs();

//        System.out.println(r1);
//        System.out.println(r2);
//        System.out.println(r3);
//        System.out.println(r4);

        assertTrue(r1.equals("sputters") || r1.equals("runs"));
        assertTrue(r2.equals("sputters") || r2.equals("runs"));
        assertTrue(r3.equals("sputters") || r3.equals("runs"));
        assertTrue(r4.equals("sputters") || r4.equals("runs"));
    }
//
//    @Test
//    public void




//    private final PrintStream standardOut = System.out;
//    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;
//    private final PrintStream originalErr = System.err;
//
//    @Before
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//        System.setErr(new PrintStream(errContent));
//    }
//
//    @Test
//    public void out() {
//        System.out.print("hello");
//        assertEquals("hello", outContent.toString());
//    }
//
//    @Test
//    public void err() {
//        System.err.print("hello again");
//        assertEquals("hello again", errContent.toString());
//    }
//
//    @After
//    public void restoreStreams() {
//        System.setOut(originalOut);
//        System.setErr(originalErr);
    }
//    @Test
//    public void testShines() {
//        LifeBoat lf1 = new LifeBoat(new VehicleUnlockStrategy());
//
//        //assertTrue(lf1.shines().equals("shines") || lf1.shines().equals("sparkles"));
//        //check sysout
//    }
//








//    @Test
//    public void testUnlock(){
//
//        Mechanic mm= new Mechanic();
//        List<Vehicle> vehicleList;
//        UnlockCommand ins = new UnlockCommand(mm, vehicleList);
//        assertNull(ins.execute());
//
//
//    }




