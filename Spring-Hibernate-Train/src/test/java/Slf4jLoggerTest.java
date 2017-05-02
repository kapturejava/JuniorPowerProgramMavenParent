import be.kapture.training.logging.LogMyInfo;
import org.junit.After;
import org.junit.Test;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static uk.org.lidalia.slf4jtest.LoggingEvent.info;

/**
 * Created by vanmoj1 on 3/04/2017.
 */
public class Slf4jLoggerTest {

    private TestLogger logger = TestLoggerFactory.getTestLogger(LogMyInfo.class);

    @Test
    public void aMethodThatLogsLogsAsExpected() {
        LogMyInfo.log();

        assertThat(logger.getLoggingEvents(), is(asList(info("Hello from LogMyInfo."))));

    }

    @After
    public void clearLoggers() {
        TestLoggerFactory.clear();
    }

}
