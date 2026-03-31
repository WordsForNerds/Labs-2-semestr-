package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Scanner;

public class HTMLparserMain {

    public static void main(String[] args){

        String url = "https://itlearn.ru/first-steps";
        Scanner scan = new Scanner(System.in);

        while (true){

            while (true){

                System.out.println("Введите цифры, чтобы определить следующие действия"
                        + "\n" + "1. Попробовать подключиться к сайту"
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

                Document doc = Jsoup.connect(url).get();
                Elements links = doc.select("a[href]");
                System.out.println("Вот ваши ссылки");
                for (Element link : links){

                    String strLink = link.attr("abs:href");
                    System.out.println(strLink);
                }
                break;
            } catch (IOException e){

                e.printStackTrace();
                System.out.println("Ошибка подлключения к сайту и считывания данных, попробуйте ещё раз!");
            }
        }
        while (true){

            while (true){

                System.out.println("Вы хотите записать полученные ссылки в отдеальный txt документ ?"
                        + "\n" + "1. Да"
                        + "\n" + "2. Нет");
                int choice = scan.nextInt();

                if (choice == 1){

                    break;
                } else if (choice == 2){

                    System.exit(0);
                }
                System.out.println("Введите цифру из предложенных двух, а не что то другое!" + "\n");
            }

            try {

                //Создаём новый файл
                File f1 = new File("D:/Files/links.txt");
                f1.createNewFile();
                if(f1.exists()){

                    System.out.println("Создан!!!!");
                    System.out.println("Полный путь1: " + f1.getAbsolutePath());

                }

                //Записываем ссылки в него
                FileWriter fileWrite = null;
                BufferedWriter buffWrite = null;

                fileWrite = new FileWriter("D:/Files/links.txt");
                buffWrite = new BufferedWriter(fileWrite);

                Document doc = Jsoup.connect(url).get();
                Elements links = doc.select("a[href]");
                for (Element link : links){

                    String strLink = link.attr("abs:href");
                    buffWrite.write(strLink);
                    buffWrite.write("\n");
                }
                //Закрываем поток и выходим из цикла
                buffWrite.close();
                break;
            } catch (IOException e){

                e.printStackTrace();
                System.out.println("Ошибка подлключения к сайту и считывания данных, попробуйте ещё раз!");
            } finally {

            }
        }
    }
}