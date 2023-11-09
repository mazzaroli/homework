import components.*;
import computer.Computer;
import devices.*;
import exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Main Class
public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws NoGhzException, InvalidKeyboardTypeException, MonitorAlreadyOnException, MonitorAlreadyOffException, MouseNotConfigurableException {
        try {
            // Creating instances of CPU, GPU, RAM, Keyboard, Monitor, and Mouse
            CPU cpu = new CPU("Core i7", "Intel", 1);
            GPU gpu3080 = new GPU("Nvidia RTX 3080", 12, 1710);
            GPU gpuAMD = new GPU("AMD Radeon RX 7900XT", 20, 2535);
            GPU gpu4090 = new GPU("Nvidia RTX 4090", 24, 2610);
            RAM ram = new RAM(16);
            Keyboard keyboard = new Keyboard("Mechanical");
            Monitor monitor = new Monitor("27-inch 4K", true);
            Mouse mouse = new Mouse("Wireless", true);

            // Creating instances of Desktop, Laptop, and Tablet that are subclasses of the Computer class
            Desktop desktop = new Desktop("ATX", "Dell", "XPS 9000", false, cpu, gpuAMD, ram, keyboard, monitor, mouse);
            Desktop desktopDefault = new Desktop();
            Laptop laptopDefault = new Laptop();
            Computer tabletDefault = new Tablet();

            monitor.setPoweredOn(true);
            monitor.setPoweredOn(false);
        } catch (NoGhzException | InvalidKeyboardTypeException | MouseNotConfigurableException | MonitorAlreadyOnException | MonitorAlreadyOffException e) {
            LOGGER.error("Exception caught: " + e.getMessage());
        }
    }
}