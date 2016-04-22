package test.java.be.kapture;

import main.java.be.kapture.HelloWorld;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by cromhjo on 21/04/2016.
 */
public class HelloWorldTest {
    private HelloWorld helloWorld;
    private ByteArrayOutputStream output;
    @Before
    public void before(){
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        helloWorld = new HelloWorld();
    }
    @Test
    public void mainTest(){
        helloWorld.main(null);
        assertEquals("Hello World", output.toString());
    }
}
