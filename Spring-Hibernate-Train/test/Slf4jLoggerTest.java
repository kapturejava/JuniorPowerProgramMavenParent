import org.junit.Test;
import org.junit.After;

import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static uk.org.lidalia.slf4jtest.LoggingEvent.info;

import be.kapture.training.main.*;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by vanmoj1 on 3/04/2017.
 */
public class Slf4jLoggerTest {

    private static final TestLogger logger = TestLoggerFactory.getTestLogger(SpringHibernateMain.class);

    @Test
    public void aMethodThatLogsLogsAsExpected() {
        //slf4jUser.aMethodThatLogs();

        assertThat(logger.getLoggingEvents(), is(Collections.singletonList(info("Hello World!"))));

    }

    @After
    public void clearLoggers() {
        TestLoggerFactory.clear();
    }

}
