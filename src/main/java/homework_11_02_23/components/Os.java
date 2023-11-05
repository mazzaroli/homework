package homework_11_02_23.components;

public final class Os {
    // Final variable
    private final String OS = "Windows";

    // Constructor for the FinalComputer class
    public Os() {
        // Add constructor logic if needed
        System.out.println("FinalComputer instance created.");
    }

    // Final method
    public final void displayOS() {
        System.out.println("Operating System: " + OS);
    }
}
