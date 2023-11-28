# Homework Readme

## File Handling and Word Count with StringUtils and FileUtils

This homework assignment involves reading text from a file, calculating the number of unique words, and writing the result back to a file. The primary requirement is to utilize `StringUtils` and `FileUtils` to implement the solution with minimal lines of code.

### Task Overview

1. **Read Text from File**: Implement a method to read text from a file.
2. **Calculate Unique Words**: Count the number of unique words in the text.
3. **Write Result to File**: Write the calculated count of unique words to a file.
4. **StringUtils and FileUtils**: Utilize methods from `StringUtils` and `FileUtils` to simplify text manipulation and file handling.

### Additional Information

- **File Text Processing**: To filter out non-letter characters from the text, use the `replaceAll` method with the regex `"[^A-Za-z ]"`.

### Implementation Guidelines

1. **Reading Text**: Use `FileUtils.readFileToString` method to read text from the file.
2. **Text Cleanup**: Utilize `StringUtils.replaceAll` to remove non-letter characters from the text.
3. **Word Count**: Employ `StringUtils.split` or similar methods to split the text into words and calculate unique word count.
4. **Writing to File**: Use `FileUtils.writeStringToFile` to write the result back to a file.