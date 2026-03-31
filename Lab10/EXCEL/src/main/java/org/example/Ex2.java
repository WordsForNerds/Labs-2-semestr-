package org.example;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Ex2 {

    public static void main (String[] args) throws IOException{

        // Открываем файл Excel для чтения
        String filePath = "D:/Files/example3.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);

        // Создаём экземпляр книги Excel из файла
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        // Получаем лист из книги по его имени
        XSSFSheet sheet = workbook.getSheet("Товары");

        // Перебираем строки и ячейки листа
        for (Row row : sheet){

            for (Cell cell : row){

                // Выводим значение ячейки на экран
                System.out.println(cell.toString() + "\t");
            }
            System.out.println();
        }

        // Закрываем файл и освобождаем ресурсы
        workbook.close();
        inputStream.close();
    }
}
