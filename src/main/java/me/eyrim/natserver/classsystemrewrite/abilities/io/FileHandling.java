package me.eyrim.natserver.classsystemrewrite.abilities.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandling {
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

    public static void writeBytes(byte[] bytes, String filePath) {
        try {
            Files.write(Path.of(filePath), bytes, StandardOpenOption.WRITE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] readBytes(String filePath) {
        try {
            return Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }

    public static String removeExtension(String fileName) {
        String[] fileNameSplit = fileName.split("[.]");

        return fileNameSplit[0];
    }
}
