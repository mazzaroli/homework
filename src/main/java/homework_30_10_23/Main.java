package homework_30_10_23;

import homework_30_10_23.components.*;
import homework_30_10_23.computer.Computer;
import homework_30_10_23.devices.Desktop;
import homework_30_10_23.devices.Laptop;
import homework_30_10_23.devices.Tablet;

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
        Mouse mouse = new Mouse("Wireless");

        // Creating instances of Desktop, Laptop, and Tablet that are subclasses of the Computer class
        Desktop desktop = new Desktop("ATX","Dell", "XPS 9000", cpu, gpuAMD, ram, keyboard, monitor, mouse);
        Laptop laptop = new Laptop(48,"Lenovo", "ThinkPad X1", cpu, gpu3080, ram, keyboard, monitor, mouse);
        Tablet tablet = new Tablet(true,"Apple", "iPad Pro", cpu, gpu4090, ram, keyboard, monitor, mouse);
        Desktop desktopDefault = new Desktop();
        Computer desktopPoly = new Desktop("ATX","Dell", "XPS 9000", cpu, gpuAMD, ram, keyboard, monitor, mouse);

        // Printing out specific properties of Desktop, Laptop, and Tablet instances
        System.out.println("Desktop Form Factor: " + desktop.getFormFactor());
        System.out.println("Battery Life In Hours: " + laptop.getBatteryLifeInHours());

        System.out.println("");
        desktopDefault.printInfo();

        System.out.println("");
        tablet.printInfo();

        System.out.println("");
        cpu.displayDetails();

        System.out.println("");
        gpu4090.displayDetails();

        // Override methods from Computer.java
        System.out.println("\nOverride methods from Computer.java:");
        System.out.println(desktop.toString());
        System.out.println(desktop.hashCode());
        System.out.println(desktop.equals(desktopPoly));
        System.out.println(desktop.equals(desktopDefault));

        // Override methods from CPU.java
        System.out.println("\nOverride methods from CPU.java:");
        System.out.println(cpu.toString());
        System.out.println(cpu.hashCode());
        System.out.println(cpu.equals(desktopPoly));
        System.out.println(cpu.equals(cpu));

        // Override methods from Monitor.java
        System.out.println("\nOverride methods from Monitor.java:");
        System.out.println(monitor.toString());
        System.out.println(monitor.hashCode());
        System.out.println(monitor.equals(monitor));
        System.out.println(monitor.equals(cpu));
    }
}
