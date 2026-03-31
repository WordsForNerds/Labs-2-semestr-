package org.example;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.ls.LSOutput;
import java.util.*;


public class JSONparserMain {

    public static void main(String[] args){

        //Создаём JSON файл с уже заданными книгами
        JSONObject library = new JSONObject();
        JSONArray books = new JSONArray();
        ObjectMapper mapper = new ObjectMapper();

        JSONObject book1 = new JSONObject();
        book1.put("title","Война и Мир");
        book1.put("author","Лев Толстой");
        book1.put("year",1869);

        JSONObject book2 = new JSONObject();
        book2.put("title","Мастер и Маргарита");
        book2.put("author","Михаил Булгаков");
        book2.put("year",1967);

        JSONObject book3 = new JSONObject();
        book3.put("title","Герой нашего времени");
        book3.put("author","Михаил Лермонтов");
        book3.put("year",1840);

        JSONObject book4 = new JSONObject();
        book4.put("title","Палата №6");
        book4.put("author","Антон Чехов");
        book4.put("year",1892);

        JSONObject book5 = new JSONObject();
        book5.put("title","Два Гусара");
        book5.put("author","Лев Толстой");
        book5.put("year",1856);

        //Добавляем эти книги в массив JSON
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        library.put("books",books);

        //Создаём класс с помощью которого будем работать с файлом JSON
        JSONparserReader readerJSON = new JSONparserReader();
        Scanner scan = new Scanner(System.in);

        //Используем метод записи информации в файл
        readerJSON.write(library);

        while (true){

            //Выводим на экран доступное содержимое JSON файла
            readerJSON.read();

            //Выводим варианты выбора для пользователя
            System.out.println("\n" + "1. Поиск книг по автору" + "\n" + "2. Добавление новой книги" + "\n"
                    + "3. Удаление книги по названию" + "\n" + "4. Закончить выполнение программы" + "\n");
            System.out.println("Введите цифру: ");

            //Обрабатываем выбор пользователя
            switch (scan.nextInt()){

                case 1: //Поиск книги по имени автора
                    scan.nextLine(); //Чтобы скипнуть остаток строки от ScanInt

                    //Используем метод поиска по имени
                    System.out.println("Введите имя автора по которому хотите найти книги");
                    readerJSON.find(scan.nextLine());

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2: //Добавление новой книги
                    scan.nextLine(); //Чтобы скипнуть остаток строки от ScanInt

                    //Создаём новый объект в который будем записывать данные от пользователя
                    JSONObject newBook = new JSONObject();

                    System.out.println("Введите название: ");
                    newBook.put("title",scan.nextLine());
                    System.out.println("Введите автора: ");
                    newBook.put("author",scan.nextLine());
                    System.out.println("Введите год выхода: ");
                    newBook.put("year",scan.nextInt());
                    scan.nextLine();

                    //Добавляем массивы в основной и записываем при помощи метода
                    books.add(newBook);
                    library.put("books",books);

                    readerJSON.write(library);
                    break;

                case 3: //Удаление книги по названию
                    scan.nextLine(); //Чтобы скипнуть остаток строки от ScanInt
                    System.out.println("Введите название книги");
                    JSONArray jsonArray = (JSONArray) library.get("books");
                    String title = scan.nextLine();
                    Iterator iterator = jsonArray.iterator();
                    while (iterator.hasNext()) {
                        JSONObject book = (JSONObject) iterator.next();
                        if (title.equals(book.get("title"))) {
                            iterator.remove();
                        }}

                    library.put("books",books);

                    readerJSON.write(library);
                    break;

                case 4: //Закончить выполнение программы
                    System.exit(0);
            }
        }
    }
}
