package be.kapture;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void add_Empty() {
        assertThat(stringCalculator.add("")).isEqualTo(0);
    }

    @Test
    public void add_One() {
        assertThat(stringCalculator.add("1")).isEqualTo(1);
        assertThat(stringCalculator.add("2")).isEqualTo(2);
    }

    @Test
    public void add_Multiple() {
        assertThat(stringCalculator.add("1,2")).isEqualTo(1 + 2);
        assertThat(stringCalculator.add("1,2,3,4")).isEqualTo(1 + 2 + 3 +4);
    }

    @Test
    public void add_Newline() {
        assertThat(stringCalculator.add("1\n2,3,4")).isEqualTo(1 + 2 + 3 +4);

        assertThatIllegalArgumentException().isThrownBy((() ->stringCalculator.add("1\n")));
    }

    @Test
    public void add_OtherDelimiter() {
        assertThat(stringCalculator.add("//;\n1;2;3;4")).isEqualTo(1 + 2 + 3 +4);

        assertThat(stringCalculator.add("//z\n1z2z3z4")).isEqualTo(1 + 2 + 3 +4);

        assertThat(stringCalculator.add("//zz\n1zz2zz3zz4")).isEqualTo(1 + 2 + 3 +4);

        assertThat(stringCalculator.add("//zz\n1zz2\n3zz4")).isEqualTo(1 + 2 + 3 +4);
    }

    @Test
    public void add_OtherDelimiter_SpecialDelimiter() {
        assertThat(stringCalculator.add("//+\n1+2+3+4")).isEqualTo(1 + 2 + 3 +4);
        assertThat(stringCalculator.add("//[\n1[2[3[4")).isEqualTo(1 + 2 + 3 +4);
        assertThat(stringCalculator.add("//*\n1*2*3*4")).isEqualTo(1 + 2 + 3 +4);
        assertThat(stringCalculator.add("//.\n1.2.3.4")).isEqualTo(1 + 2 + 3 +4);
        assertThat(stringCalculator.add("//^\n1^2^3^4")).isEqualTo(1 + 2 + 3 +4);

        assertThat(stringCalculator.add("//++\n1++2++3++4")).isEqualTo(1 + 2 + 3 +4);
        assertThat(stringCalculator.add("//+z\n1+z2+z3+z4")).isEqualTo(1 + 2 + 3 +4);

    }




}