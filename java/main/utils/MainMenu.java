package main.utils;
import main.IOUtiles.ExportFile;
import main.IOUtiles.ImportFile;

import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);
    int point;
    public void mainMenu(){
        do {
        System.out.println("""
        Select the required menu item:
             1 - Money transfer
             2 - Get report
             3 - Import file(s)
             4 - Export file(s)
             0 - Exit menu       
""");
            System.out.print("Enter number: ");
        point = scanner.nextInt();
        switch (point){

            case 1 ->
                System.out.println("Money transfer");
            case 2->
                System.out.println("Get report");
            case 3-> {
                System.out.println("Import file(s)");
                scanner.nextLine();                                 //зануление сканнера
                ImportFile importFile = new ImportFile(scanner);  //Обьект класса импорт файл
                importFile.setDirectoryPath();                  // Проверка директории
                importFile.readFiles();                          //  Парсинг файлов из директории (пока только пример, который выводит информацию в консоль)
            }
            case 4->{
                System.out.println("Export file(s)");
                scanner.nextLine();                                 //зануление сканнера
                ExportFile exportFile = new ExportFile(scanner);
                exportFile.setFileName();
                System.out.println(exportFile.getFileName());
                exportFile.setDirectoryPath();
                System.out.println(exportFile.getDirectoryPath());
                exportFile.writeFile("привет мир, надеюсь все записалось");
                System.out.println(exportFile.getDirectoryPath());



            }
            case 0->
                System.out.println("Exit menu");

            default->
                System.out.println("This function is not ready yet.");

        }


        }while(point!=0);



    }

}
