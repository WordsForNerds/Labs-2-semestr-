package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.stream.Collectors;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class XMLparserMain {

    public static void main(String[] args){

        XMLparserMethods xmLparserMethods = new XMLparserMethods();
        Scanner scan = new Scanner(System.in);

        try {

            //Создаём файл и заполняем
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Создание корневого элемента
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("library");
            doc.appendChild(rootElement);

            //Добавление первой книги
            Element book1 = doc.createElement("book");
            rootElement.appendChild(book1);

            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("Война и Мир"));
            book1.appendChild(title1);

            Element author1 = doc.createElement("author");
            author1.appendChild(doc.createTextNode("Лев Толстой"));
            book1.appendChild(author1);

            Element year1 = doc.createElement("year");
            year1.appendChild(doc.createTextNode("1869"));
            book1.appendChild(year1);

            //Добавление второй книги
            Element book2 = doc.createElement("book");
            rootElement.appendChild(book2);

            Element title2 = doc.createElement("title");
            title2.appendChild(doc.createTextNode("Мастер и Маргарита"));
            book2.appendChild(title2);

            Element author2 = doc.createElement("author");
            author2.appendChild(doc.createTextNode("Михаил Булгаков"));
            book2.appendChild(author2);

            Element year2 = doc.createElement("year");
            year2.appendChild(doc.createTextNode("1967"));
            book2.appendChild(year2);

            xmLparserMethods.write(doc);

            while (true){

                //Выводим на экран доступное содержимое JSON файла
                xmLparserMethods.read();

                //Выводим варианты выбора для пользователя
                System.out.println("\n" + "1. Поиск книг по автору" + "\n" + "2. Поиск книг по году" + "\n" + "3. Добавление новой книги" + "\n"
                        + "4. Удаление книги по названию" + "\n" + "5. Закончить выполнение программы" + "\n");
                System.out.println("Введите цифру: ");

                //Обрабатываем выбор пользователя
                switch (scan.nextInt()){

                    case 1: //Поиск книги по имени автора
                        scan.nextLine();

                        System.out.println("Введите автора");
                        xmLparserMethods.findAuthor(scan.nextLine());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 2: //Поиск книги по году
                        scan.nextLine();

                        System.out.println("Введите год");
                        xmLparserMethods.findYear(scan.nextLine());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 3: //Добавление новой книги
                        scan.nextLine();

                        Element newBook = doc.createElement("book");
                        rootElement.appendChild(newBook);

                        Element newTitle = doc.createElement("title");
                        System.out.println("Введите название: ");
                        newTitle.appendChild(doc.createTextNode(scan.nextLine()));
                        newBook.appendChild(newTitle);

                        Element newAuthor = doc.createElement("author");
                        System.out.println("Введитя имя автора: ");
                        newAuthor.appendChild(doc.createTextNode(scan.nextLine()));
                        newBook.appendChild(newAuthor);

                        Element newYear = doc.createElement("year");
                        System.out.println("Введите год: ");
                        newYear.appendChild(doc.createTextNode(scan.nextLine()));
                        newBook.appendChild(newYear);

                        xmLparserMethods.write(doc);
                        break;

                    case 4: //Удаление книги по названию
                        scan.nextLine();

                        System.out.println("Введите название книги, которую хотите удалить: ");

                        xmLparserMethods.remove(scan.nextLine());
                        break;

                    case 5: //Закончить выполнение программы
                        System.exit(0);
                }
            }

        } catch (Exception pce){

            pce.printStackTrace();
        }
    }
}
