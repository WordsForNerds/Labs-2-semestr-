package org.example;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Ex1 {

    public static void main(String[] args) throws IOException {

        // Создаём новую книгу Excel
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Создаём новый лист в книге
        XSSFSheet sheet = workbook.createSheet("Товары");

        // Записываем данные в ячейки
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

        // Записываем книгу Excel в файл
        String filePath = "D:/Files/example3.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("Данные записаны в файл: " + filePath);
    }
}