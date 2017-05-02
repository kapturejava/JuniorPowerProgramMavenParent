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

    @Test
    public void testTopHoursShouldHave4Lamps() {
        Assert.assertEquals(4, berlinClock.getTopHours(7).length());
    }

    @Test
    public void testTopHoursShouldLightRedLampForEvery5Hours() {
        Assert.assertEquals("OOOO", berlinClock.getTopHours(0));
        Assert.assertEquals("RROO", berlinClock.getTopHours(13));
        Assert.assertEquals("RRRR", berlinClock.getTopHours(23));
        Assert.assertEquals("RRRR", berlinClock.getTopHours(24));
    }

}
