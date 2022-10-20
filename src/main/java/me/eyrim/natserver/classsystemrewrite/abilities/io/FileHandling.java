package me.eyrim.natserver.classsystemrewrite.abilities.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Contains methods relating to the handling of files for the entire project
 */
public class FileHandling {
    /**
     * Reads a file from the disk to a string. <br\>
     *
     * <h2>This method checks nothing about the file itself, only it's content.</h2>
     * @param filePath The path of the file to read
     * @return A string containing the contents of the file.<br\>If an exception is raised, the method will print the exception and return ""
     */
    public static String readFileToString(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            StringBuilder fileData = new StringBuilder();

            while (scanner.hasNextLine()) {
                fileData.append(scanner.nextLine());
            }

            return fileData.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return "";
        }
    }

    /**
     * Reads a file from the disk to an ArrayList&lt;String&gt; <br\>
     *
     * <h2>This method checks nothing about the file itself, only it's content.</h2>
     * @param filePath The path of the file to read
     * @return An ArrayList&lt;String&gt; containing the contents of the file.<br\>If an exception is raised, the method will print the exception and return null
     */
    public static List<String> readFileToList(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            List<String> fileData = new ArrayList<String>();

            while (scanner.hasNextLine()) {
                fileData.add(scanner.nextLine());
            }

            return fileData;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    /**
     * <h1>WARNING: THIS METHOD OVERWRITES THE FILE</h1> <br\>
     * Writes a byte array to a file <br\>
     *
     * <h2>This method checks nothing about the file itself, only it's content</h2>
     * @param bytes The byte array to write to the file
     * @param filePath The path of the file to write to
     */
    public static void writeBytes(byte[] bytes, String filePath) {
        try {
            Files.write(Path.of(filePath), bytes, StandardOpenOption.WRITE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads a file as bytes to a Byte[] <br\>
     *
     * <h2>This method checks nothing about the file itself, only its content</h2>
     * @param filePath The path of the file to read
     * @return A byte[] containing the data stored in the file.<br\>If an exception is raised, this method will print it and return null
     */
    public static byte[] readBytes(String filePath) {
        try {
            return Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }

    /**
     * Utility method to remove the last file extension from a given file name <br\>
     *
     * <h3>Examples:</h3>
     * <ol>
     *     <code>myJsonFile.json</code> will be converted into <code>myJsonFile</code> <br\><br\>
     *     <code>start.bat.txt</code> will be converted into <code>start.bat</code>
     * </ol>
     * @param fileName The path of the file to read
     * @return The modified path name as a String
     */
    public static String removeExtension(String fileName) {
        String[] fileNameSplit = fileName.split("[.]");

        return fileNameSplit[0];
    }
}
