package org.example;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONparserReader {

    //Метод для чтения содержимого JSON файла
    public void read() {

        try {

            JSONParser parser = new JSONParser();
            Object obj = parser
                    .parse(new FileReader("D:/Files/example-json.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("Корневой элемент: "
                    + jsonObject.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            for (Object o : jsonArray) {

                JSONObject book = (JSONObject)  o;
                System.out.println("\nТекущий элемент: book");
                System.out.println("Название книги: " + book.get("title"));
                System.out.println("Автор: " + book.get("author"));
                System.out.println("Год издания: " + book.get("year"));
            }
        } catch (Exception e){

            e.printStackTrace();
        }
    }
    //Метод для нахождения нужных эелементов по имени автора и выводу результата в консоль
    public void find(String str){

        try {

            JSONParser parser = new JSONParser();
            Object obj = parser
                    .parse(new FileReader("D:/Files/example-json.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("Корневой элемент: "
                    + jsonObject.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            for (Object o : jsonArray) {

                JSONObject book = (JSONObject)  o;
                if (book.get("author").equals(str)){
                    System.out.println("\nТекущий элемент: book");
                    System.out.println("Название книги: " + book.get("title"));
                    System.out.println("Автор: " + book.get("author"));
                    System.out.println("Год издания: " + book.get("year"));
                }
            }
        } catch (Exception e){

            e.printStackTrace();
        }
    }

    //Метод для записи массива JSON в файл
    public void write(JSONObject library){

        ObjectMapper mapper = new ObjectMapper();

        try{

            mapper.writeValue(new File("D:/Files/example-json.json"), library );

            System.out.println("Json файл успешно создан!");
        } catch (Exception e){

            e.printStackTrace();
        }
    }
}
