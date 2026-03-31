package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Ex1 {

    public static void main(String[] args){

        String url = "https://itlearn.ru/first-steps";
        try {

            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for (Element link : links){

                String strLink = link.attr("abs:href");
                System.out.println(strLink);
            }
        } catch (IOException e){

            e.printStackTrace();
        }
    }
}
