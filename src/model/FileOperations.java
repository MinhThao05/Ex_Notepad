package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileOperations {

    public static void createFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        Files.createFile(filePath);
    }

    public static void writeFile(String fileName, String data) throws IOException {
        Path filePath = Paths.get(fileName);
        Files.write(filePath, data.getBytes(), StandardOpenOption.CREATE);
    }

    public static String readFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        List<String> lines = Files.readAllLines(filePath);
        StringBuilder content = new StringBuilder();
        for (String line : lines) {
            content.append(line).append("\n");
        }
        return content.toString();
    }

    public static String getFilePath(String fileName) {
        Path filePath = Paths.get(fileName);
        return filePath.toAbsolutePath().toString();
    }

    public static void deleteFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        Files.delete(filePath);
    }

    public static void createDirectory(String directoryName) throws IOException {
        Path directoryPath = Paths.get(directoryName);
        Files.createDirectories(directoryPath);
    }

    public static void main(String[] args) throws IOException {
        String fileName = "test.txt";
        createFile(fileName);
        writeFile(fileName, "Hello, world!");
        System.out.println(readFile(fileName));
        System.out.println(getFilePath(fileName));
        deleteFile(fileName);
    }
}