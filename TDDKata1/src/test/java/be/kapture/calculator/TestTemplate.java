package be.kapture.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vanmoj1 on 14/04/2017.
 */
public class TestTemplate {
    private Calculator calculator;

    @Before
    public void beforeMethod() {
        calculator = new Calculator();
    }

    @Test
    public void testIfTwoStringNumbersAddCorrect() {
        int sum = calculator.Add("3,4");
        assertEquals(7, sum);
    }

    @Test
    public void testIfOneStringNumberReturnsNumber() {
        int sum = calculator.Add("3");
        assertEquals(3, sum);
    }

    @Test
    public void testIfEmptyStringNumbersReturnsZero() {
        int sum = calculator.Add("");
        assertEquals(0, sum);
    }
}
