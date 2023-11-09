package components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Os {
    private static final Logger logger = LogManager.getLogger(Os.class);

    private final String OS = "Windows";

    static LocalDateTime now = LocalDateTime.now();
    static String time = now.format(DateTimeFormatter.ISO_TIME);

    static {
        logger.info("Os is being loaded.");
    }

    public Os() {
        logger.info("Os instance created.");
    }

    public final void displayOS() {
        logger.info("Operating System: {}", OS);
    }

    public static void shutDown() {
        logger.info("Os Shut Down at: {}", time);
    }
}

// https://stackoverflow.com/questions/2654025/how-to-get-year-month-day-hours-minutes-seconds-and-milliseconds-of-the-cur