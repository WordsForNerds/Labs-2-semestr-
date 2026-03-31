package org.example;

import java.io.*;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;


public class EXCELparserMain {

    public static void main (String[] args) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        Scanner scan = new Scanner(System.in);
        XSSFSheet sheet = workbook.createSheet("Товары");

        Row dataRow1 = sheet.createRow(0);
        dataRow1.createCell(0).setCellValue("Товар");
        dataRow1.createCell(1).setCellValue("Характеристики");
        dataRow1.createCell(2).setCellValue("Стоимость");

        Row dataRow2 = sheet.createRow(1);
        dataRow2.createCell(0).setCellValue("Книга");
        dataRow2.createCell(1).setCellValue("Жанр: Фантастика, Автор: Иванов И.И.");
        dataRow2.createCell(2).setCellValue(500.0);

        Row headerRow = sheet.createRow(2);
        headerRow.createCell(0).setCellValue("Компьютер");
        headerRow.createCell(1).setCellValue("Процессор Intel Core i5, Оперативная память");
        headerRow.createCell(2).setCellValue("Стоимость");

        String filePath = "D:/Files/example3.xlsx";

        //Пытаемся создать файл до тех пор, пока не получится
        while (true){

            while (true){

                System.out.println("Введите цифры, чтобы определить следующие действия"
                        + "\n" + "1. Создать новый Excel файл"
                        + "\n" + "2. Сдаться");
                int choice = scan.nextInt();

                if (choice == 1){

                    break;
                } else if (choice == 2){

                    System.out.println("Не стоило разрбрасываться словами");
                    System.exit(0);
                }
                System.out.println("Введите цифру из предложенных двух, а не что то другое!" + "\n");
            }

            try {

                FileOutputStream outputStream = new FileOutputStream(filePath);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();

                break;
            } catch (IOException e) {

                e.printStackTrace();
                System.out.println("Возникла ошибка при записывани Excel книги в файл!"
                + "Проверьте, доступен ли указанный путь к файлу и достаточно ли метса на диске");
            }
        }

        //Пытаемся прочитать файл пока не получится
        while (true){

            while (true){

                System.out.println("Введите цифры, чтобы определить следующие действия"
                        + "\n" + "1. Прочитать созданный Excel файл"
                        + "\n" + "2. Сдаться");
                int choice = scan.nextInt();

                if (choice == 1){

                    break;
                } else if (choice == 2){

                    System.out.println("Не стоило разрбрасываться словами");
                    System.exit(0);
                }
                System.out.println("Введите цифру из предложенных двух, а не что то другое!" + "\n");
            }


            try {

                FileInputStream inputStream = new FileInputStream(filePath);
                XSSFWorkbook workbookread = new XSSFWorkbook(inputStream);
                XSSFSheet sheetread = workbookread.getSheet("Товары");

                for (Row row : sheetread){

                    for (Cell cell : row){

                        // Выводим значение ячейки на экран
                        System.out.println(cell.toString() + "\t");
                    }
                    System.out.println();
                }

                workbook.close();
                inputStream.close();
                break;
            } catch (IOException e) {

                e.printStackTrace();
                System.out.println("Возникла ошибка при чтении Excel файла!"
                + "Для устранения ошибки попробуйте проверить целостность накопителя"
                + " или кабеля к которому он подключён");
            }
        }

        System.out.println("Файл был успешно записан и прочитан, все молодцы");
    }
}


