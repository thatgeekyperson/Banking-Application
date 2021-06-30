import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
//import org.testng.annotations.Test;
import org.junit.Test;
//import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSout {

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.out.println("before");
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void out() {
        print("hello");
        assertEquals("hello", outContent.toString().trim());
    }

    private void print(String hello) {
        System.out.println(hello);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }





}
