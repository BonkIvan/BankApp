package main.IOUtiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExportFile {
    File file;
    String defaultPath = "java/";
    Scanner scanner;

    public ExportFile(Scanner scanner) {
        this.scanner = scanner;
    }

    private String fileName;
    private String directoryPath;


    public String getFileName() {
        return fileName;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setFileName() {
        System.out.println("enter a filename: ");
        fileName = scanner.nextLine();
        if (fileName == null || fileName.isEmpty()) {
            System.out.println("Invalid name, set default name - output.txt");
            fileName = "output.txt";
        }
    }

    public void setDirectoryPath() {
        System.out.println("Enter a directory path: ");
        directoryPath = scanner.nextLine();
        file = new File(directoryPath);
        if (!file.isDirectory()) {
            System.out.println("Path invalid, set path defult " + defaultPath);
            directoryPath = defaultPath;
            file = new File(directoryPath);
        }
        if (file.exists()) {
            System.out.println("All right");
            file.getAbsoluteFile();
        } else {
            System.out.println("Not all right");
            System.out.println(file.getPath() + 25);
        }

    }

    public void writeFile(String string){               //пока в метод передается просто строка для проверки

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(directoryPath+"/"+fileName))) {
            writer.write(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
