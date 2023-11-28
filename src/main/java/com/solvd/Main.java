package com.solvd;// Importing necessary com.solvd.components and com.solvd.exceptions
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.fileProcessor.FileProcessor;

// com.solvd.Main Class
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args){
        String inputFile = "src/main/resources/input.txt";
        String outputDirectory = "src/output";

        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.processFile(inputFile, outputDirectory,"output1",false);
        fileProcessor.processFile(inputFile, outputDirectory,"output2",true);
    }
}