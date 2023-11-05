package homework_10_26_23.components.homework_26_10_23;

import homework_10_26_23.components.homework_26_10_23.components.*;
import homework_10_26_23.components.homework_26_10_23.devices.Desktop;
import homework_10_26_23.components.homework_26_10_23.devices.Laptop;
import homework_10_26_23.components.homework_26_10_23.devices.Tablet;

// Main Class
public class Main {
    public static void main(String[] args) {
        // Creating instances of CPU, GPU, RAM, Keyboard, Monitor, and Mouse
        CPU cpu = new CPU("Intel Core i7");
        GPU gpu3080 = new GPU("Nvidia RTX 3080");
        GPU gpuAMD = new GPU("AMD Radeon™ RX Serie 7000");
        GPU gpu4090 = new GPU("Nvidia RTX 4090");
        RAM ram = new RAM(16);
        Keyboard keyboard = new Keyboard("Mechanical");
        Monitor monitor = new Monitor("27-inch 4K");
        Mouse mouse = new Mouse("Wireless");

        // Creating instances of Desktop, Laptop, and Tablet that are subclasses of the Computer class
        Desktop desktop = new Desktop("ATX","Dell", "XPS 9000", cpu, gpuAMD, ram, keyboard, monitor, mouse);
        Laptop laptop = new Laptop(48,"Lenovo", "ThinkPad X1", cpu, gpu3080, ram, keyboard, monitor, mouse);
        Tablet tablet = new Tablet(true,"Apple", "iPad Pro", cpu, gpu4090, ram, keyboard, monitor, mouse);
        Desktop desktopDefault = new Desktop();

        // Printing out specific properties of Desktop, Laptop, and Tablet instances
        System.out.println("Desktop Form Factor: " + desktop.getFormFactor());
        System.out.println("Battery Life In Hours: " + laptop.getBatteryLifeInHours());

        System.out.println("");
        desktopDefault.printInfo();

        System.out.println("");
        tablet.printInfo();
    }
}