package be.kapture.calculator;

import exceptions.NegativeNumberNotAllowedException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by vanmoj1 on 14/04/2017.
 */
public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void beforeMethod() {
        calculator = new Calculator();
    }

    @Test(expected = NegativeNumberNotAllowedException.class)
    public void testIfNegativeStringNumberThrowsException() {
        int sum = calculator.Add("-15,10");

    }

    @Test
    public void testIfTwoStringNumbersAddWithAnyLengthDelimiter() {
        int sum = calculator.Add("//***\n1***2***3");
        assertEquals(6, sum);
    }

    @Test
    public void testIfStringNumbersBiggerThenThousandAreIgnored() {
        int sum = calculator.Add("//;\n2;1001");
        assertEquals(2, sum);
    }

    @Test
    public void testIfTwoStringNumbersAddWithDefaultDelimiter() {
        int sum = calculator.Add("//;\n10;20");
        assertEquals(30, sum);
    }

    @Test
    public void testIfUnknownNumberOfStringNumbersWithNewLineDelimiterAddCorrect() {
        int sum = calculator.Add("15\n10,4,8\n9,4,12");
        assertEquals(62, sum);
    }

    @Test
    public void testIfUnknownNumberOfStringNumbersAddCorrect() {
        int sum = calculator.Add("15,10,4,8,9,4,12");
        assertEquals(62, sum);
    }

    @Test
    public void testIfTwoStringNumbersWithNewLineAddCorrect() {
        int sum = calculator.Add("15\n10");
        assertEquals(25, sum);
    }

    @Test
    public void testIfTwoStringNumbersAddCorrect() {
        int sum = calculator.Add("15,10");
        assertEquals(25, sum);
    }

    @Test
    public void testIfOneStringNumberReturnsNumber() {
        int sum = calculator.Add("33");
        assertEquals(33, sum);
    }

    @Test
    public void testIfEmptyStringNumbersReturnsZero() {
        int sum = calculator.Add("");
        assertEquals(0, sum);
    }
}
