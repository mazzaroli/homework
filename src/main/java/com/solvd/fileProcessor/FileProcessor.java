package com.solvd.fileProcessor;

// Import necessary libraries
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Class responsible for processing files and extracting unique words.
 */
public class FileProcessor {
    private static final Logger logger = LogManager.getLogger(FileProcessor.class);

    /**
     * Process the given input file and generate an output file with unique words or their count.
     *
     * @param inputFile         The path to the input file to be processed.
     * @param outputDirectory   The directory where the output file will be created.
     * @param outputFileName    The name of the output file to be generated.
     * @param printUniqueWords  A boolean flag indicating whether to print unique words or their count.
     */
    public void processFile(String inputFile, String outputDirectory, String outputFileName, boolean printUniqueWords) {
        // Log information about processing file
        logger.info("Processing text from {} to {}", inputFile, outputDirectory);

        // Check if input parameters are not null
        if (inputFile != null && outputDirectory != null && outputFileName != null) {
            try {
                // Read text from the input file and join lines into a single string
                String text = StringUtils.join(FileUtils.readLines(new File(inputFile), StandardCharsets.UTF_8), " ");

                // Split text into words, convert to lowercase, and store unique words in a set
                Set<String> uniqueWords = new HashSet<>(Arrays.asList(StringUtils.split(text.toLowerCase())));

                // Create the output file path
                String outputFilePath = outputDirectory + File.separator + outputFileName;

                // Write either unique words or the count of unique words to the output file based on the boolean flag
                if (printUniqueWords) {
                    FileUtils.writeStringToFile(new File(outputFilePath), "Unique words in the text: " + uniqueWords, StandardCharsets.UTF_8);
                } else {
                    FileUtils.writeStringToFile(new File(outputFilePath), "Number of unique words in the text: " + uniqueWords.size(), StandardCharsets.UTF_8);
                }
            } catch (IOException e) {
                // Log an error if an IOException occurs during file processing
                logger.error(e.getMessage());
            }
            // Log information that text processing is complete
            logger.info("Text processed");
        } else {
            // Log a warning if any of the Strings is null
            logger.warn("One of the Strings is null");
        }
    }

    // Override toString method to provide string representation of the class
    @Override
    public String toString() {
        return "Text{}";
    }
}