package be.kapture.training.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by vanmoj1 on 4/04/2017.
 */
public abstract class LogMyInfo {
    private static final Logger logger = LoggerFactory.getLogger(LogMyInfo.class);

    public static void log() {
        //String name = "Jo";

        logger.info("Hello from LogMyInfo.");

        //logger.debug("In LogMyInfo my name is {}.", name);
    }
}
