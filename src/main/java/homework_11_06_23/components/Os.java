package homework_11_06_23.components;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Os {
    // Final variable
    private final String OS = "Windows";

    static LocalDateTime now = LocalDateTime.now();
    static String time = now.format(DateTimeFormatter.ISO_TIME);

    static {
        System.out.println("Os is being loaded.");
    }

    // Constructor for the FinalComputer class
    public Os() {
        // Add constructor logic if needed
        System.out.println("Os instance created.");
    }

    // Final method
    public final void displayOS() {
        System.out.println("Operating System: " + OS);
    }

    // Static method
    public static void shutDown() {
        System.out.println("Os Shut Down at: " + time);
    }
}

// https://stackoverflow.com/questions/2654025/how-to-get-year-month-day-hours-minutes-seconds-and-milliseconds-of-the-cur