//import CPU;
import components.*;
import devices.*;
import computer.Computer;
import exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Main Class
public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws NoGhzException, InvalidKeyboardTypeException, MonitorAlreadyOnException, MonitorAlreadyOffException, MouseNotConfigurableException {
        // Creating instances of CPU, GPU, RAM, Keyboard, Monitor, and Mouse
        CPU cpu = new CPU("Core i7","Intel ",1);
        GPU gpu3080 = new GPU("Nvidia RTX 3080", 12, 1710);
        GPU gpuAMD = new GPU("AMD Radeon RX 7900XT", 20, 2535);
        GPU gpu4090 = new GPU("Nvidia RTX 4090", 24, 2610);
        RAM ram = new RAM(16);
        Keyboard keyboard = new Keyboard("Mechanical");
        Monitor monitor = new Monitor("27-inch 4K", false);
        Mouse mouse = new Mouse("Wireless",true);
        Mouse mouse1 = new Mouse("Wireless",false);

        // Creating instances of Desktop, Laptop, and Tablet that are subclasses of the Computer class
        Desktop desktop = new Desktop("ATX","Dell", "XPS 9000", false, cpu, gpuAMD, ram, keyboard, monitor, mouse);
        Laptop laptop = new Laptop(48,"Lenovo", "ThinkPad X1",true,cpu, gpu3080, ram, keyboard, monitor, mouse);
        Tablet tablet = new Tablet(true,"Apple", false,"iPad Pro", cpu, gpu4090, ram, keyboard, monitor, mouse);
        Computer desktopPoly = new Desktop("ATX","Dell", "XPS 9000", false,cpu, gpuAMD, ram, keyboard, monitor, mouse);

        // Creating defaults instances of Desktop, Laptop, and Tablet
        Desktop desktopDefault = new Desktop();
        Laptop laptopDefault = new Laptop();
        Computer tabletDefault = new Tablet();

        laptop.upgrade();
    }
}
