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
    public void testBottomHoursShouldHave4Lamps() {
        Assert.assertEquals(4, berlinClock.getBottomHours(5).length());
    }

    @Test
    public void testTopHoursShouldLightRedLampForEvery5Hours() {
        Assert.assertEquals("OOOO", berlinClock.getTopHours(0));
        Assert.assertEquals("RROO", berlinClock.getTopHours(13));
        Assert.assertEquals("RRRR", berlinClock.getTopHours(23));
        Assert.assertEquals("RRRR", berlinClock.getTopHours(24));
    }

    @Test
    public void testTopHoursShouldLightRedLampForEveryHourLeftFromTopHours() {
        Assert.assertEquals("OOOO", berlinClock.getBottomHours(0));
        Assert.assertEquals("RRRO", berlinClock.getBottomHours(13));
        Assert.assertEquals("RRRO", berlinClock.getBottomHours(23));
        Assert.assertEquals("RRRR", berlinClock.getBottomHours(24));
    }

    @Test
    public void testTopMinutesShouldHave11Lamps() {
        Assert.assertEquals(11, berlinClock.getTopMinutes(34).length());
    }

    @Test
    public void testTopMinutesShouldHave3rd6thAnd9thLampsInRedToIndicateFirstQuarterHalfOrLastQuarter() {
        String minutes32 = berlinClock.getTopMinutes(32);

        Assert.assertEquals("R", minutes32.substring(2, 3));
        Assert.assertEquals("R", minutes32.substring(5, 6));
        Assert.assertEquals("O", minutes32.substring(8, 9));
    }

    @Test
    public void testTopMinutesShouldLightYellowLampForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
        Assert.assertEquals("OOOOOOOOOOO", berlinClock.getTopMinutes(0));
        Assert.assertEquals("YYROOOOOOOO", berlinClock.getTopMinutes(17));
        Assert.assertEquals("YYRYYRYYRYY", berlinClock.getTopMinutes(59));
    }

}
