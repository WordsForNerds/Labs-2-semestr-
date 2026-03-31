package org.example;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Ex1 {

    public static void main(String[] args){

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

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        library.put("books",books);

        try{

            mapper.writeValue(new File("D:/Files/example-json.json"), library );

            System.out.println("Json файл успешно создан!");
        } catch (Exception e){

            e.printStackTrace();
        }
    }
}
