import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vanmoj1 on 28/04/2017.
 */
public class BerlinClockTest {
    private BerlinClock berlinClock;

    @Before
    public void beforeMethod() {
        berlinClock = new BerlinClock();
    }

    @Test
    public void testYellowLampShouldBlinkOnOffEveryTwoSeconds() {
        Assert.assertEquals("Y", berlinClock.getSeconds(0));
        Assert.assertEquals("O", berlinClock.getSeconds(1));
        Assert.assertEquals("O", berlinClock.getSeconds(59));
    }

}
