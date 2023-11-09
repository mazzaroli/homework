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

        // Creating instances of Desktop, Laptop, and Tablet that are subclasses of the Computer class
        Desktop desktop = new Desktop("ATX","Dell", "XPS 9000", false, cpu, gpuAMD, ram, keyboard, monitor, mouse);
        Laptop laptop = new Laptop(48,"Lenovo", "ThinkPad X1",true,cpu, gpu3080, ram, keyboard, monitor, mouse);
        Tablet tablet = new Tablet(true,"Apple", false,"iPad Pro", cpu, gpu4090, ram, keyboard, monitor, mouse);
        Computer desktopPoly = new Desktop("ATX","Dell", "XPS 9000", false,cpu, gpuAMD, ram, keyboard, monitor, mouse);

        // Creating defaults instances of Desktop, Laptop, and Tablet
        Desktop desktopDefault = new Desktop();
        Laptop laptopDefault = new Laptop();
        Computer tabletDefault = new Tablet();

        mouse.click(); // [INFO ] 2023-11-09 00:54:56.741 [main] Mouse - Mouse does click click click
        laptop.upgrade(); // [INFO ] 2023-11-09 00:54:56.747 [main] Laptop - Laptop is upgradable. Performing the upgrade...

        mouse.configure(); // [INFO ] 2023-11-09 00:55:19.739 [main] Mouse - Mouse is configurable. Configuring the mouse...
        mouse.setConfigurable(false); // Mouse use a try catch
        mouse.configure(); // [ERROR] 2023-11-09 00:57:49.453 [main] Mouse - Error: Mouse is not configurable.

        monitor.powerOn(); // [INFO ] 2023-11-09 00:55:46.951 [main] Monitor - The monitor is powered on.
        monitor.powerOff(); // [INFO ] 2023-11-09 00:55:46.951 [main] Monitor - The monitor is powered off
        // monitor.powerOff(); // Exception in thread "main" exceptions.MonitorAlreadyOffException: Monitor is already powered off.
        keyboard.connect(); // [INFO ] 2023-11-09 00:56:45.169 [main] Keyboard - Keyboard connected.
        keyboard.setType("Fail");
        // keyboard.connect(); // Exception in thread "main" exceptions.InvalidKeyboardTypeException: Invalid keyboard type. Only Mechanical or Membrane keyboards are allowed.

        laptop.printInfo();
        /*[INFO ] 2023-11-09 00:58:48.555 [main] Laptop - Laptop:
            From Computer{ brand='Lenovo', model='ThinkPad X1', Upgradable='true' }
            Battery Life In Hours: 48
            CPU: Core i7
            GPU: Nvidia RTX 3080
            RAM: 16
            Keyboard: Fail
            Monitor: 27-inch 4K
            Mouse: Wireless
            */
    }
}
