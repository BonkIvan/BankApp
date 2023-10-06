package main.IOUtiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ImportFile {
    Scanner scanner;

    public ImportFile(Scanner scanner) {
        this.scanner = scanner;
    }


    private String directoryPath = null;
    File directory;

    public void setDirectoryPath() {
        directoryPath = scanner.nextLine();
        directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            System.out.println("Invalid path");
            return;
        } else System.out.println("Valid path");

    }

    public void readFiles() {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("Чтение файла: " + file.getName());
                    parserFile(file);
                }
            }
        }
    }


//TODO после получения информайии о файле для парсинга разобрать метод на состовляющие
    public void parserFile(File file){
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;

            while ((line = reader.readLine())!=null){
                System.out.println(line);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




}
