package homework_11_06_23;

//import CPU;
import homework_11_06_23.components.*;
import homework_11_06_23.computer.Computer;
import homework_11_06_23.devices.*;

// Main Class
public class Main {
    public static void main(String[] args) {
        // Creating instances of CPU, GPU, RAM, Keyboard, Monitor, and Mouse
        CPU cpu = new CPU("Core i7","Intel ",2.6);
        GPU gpu3080 = new GPU("Nvidia RTX 3080", 12, 1710);
        GPU gpuAMD = new GPU("AMD Radeon RX 7900XT", 20, 2535);
        GPU gpu4090 = new GPU("Nvidia RTX 4090", 24, 2610);
        RAM ram = new RAM(16);
        Keyboard keyboard = new Keyboard("Mechanical");
        Monitor monitor = new Monitor("27-inch 4K");
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
        CPU cpuDefault = new CPU();
    }
}
