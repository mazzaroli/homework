package com.solvd;

import com.solvd.database.controller.RamController;
import com.solvd.database.dao.*;
import com.solvd.database.model.Ram;
import com.solvd.database.strategy.SortByCapacity;
import com.solvd.database.util.dao.DAOFactoryGenerator;
import com.solvd.database.view.ConsoleRamView;
import com.solvd.database.view.RamView;
import com.solvd.enums.FactoryType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.solvd.enums.DAOType.RAM;

// Clase A con un método
class ClaseA {
    public void metodoA() {
        System.out.println("Hola desde el método A de la ClaseA");
    }
}

// Clase B con otro método independiente
class ClaseB {
    public void metodoB() {
        System.out.println("Saludos desde el método B de la ClaseB");
    }
}


// Clase principal que utiliza ambas clases y sus métodos
public class Main {

    public static void main(String[] args) {
        ClaseA instanciaA = new ClaseA();
        ClaseB instanciaB = new ClaseB();

//         Llamar al método de la ClaseA
        instanciaA.metodoA();

        // Llamar al método de la ClaseB
        instanciaB.metodoB();
    }
}


