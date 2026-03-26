import java.util.*;
import java.util.stream.Collectors;

public class Task5 {

    //Создаём функцию для фильтрации строк
    public static List<String> viborka (List<String> list, String str){

        return list.stream()
                .filter ( s -> s.contains(str))
                .collect (Collectors.toList());
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        //Сюда мы запишем выбор пользователя
        String str;

        String string = "Напишите функцию, которая принимает на вход список " +
                "строк и возвращает новый список, Содержащий только те строки, " +
                "которые начинаются с большйо буквы.";

        //Разделяем строку и выводим
        List<String> strings = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплитования : " + "\n");
        for (String e : strings){

            System.out.println(e);
        }

        System.out.println("Напишите строку по которой будет проихзводиться выборка: ");
        str = scan.nextLine();

        List<String> strAfter = viborka(strings, str);

        System.out.println("\n" + "Строка после преобразования : " + "\n");
        for (String e : strAfter){

            System.out.println(e);
        }
    }
}
