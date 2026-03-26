import java.util.*;
import java.util.stream.Collectors;

public class Task3 {

    public static List<String> filgerCapitalizedStrings (List<String> list){

        return list.stream()
                .filter ( s -> Character.isUpperCase (s.charAt(0)))
                .collect (Collectors.toList());
    }

    public static void main(String[] args){

        String str = "Напишите функцию, которая принимает на вход список " +
                "строк и возвращает новый список, Содержащий только те строки, " +
                "которые начинаются с большйо буквы.";

        List<String> strings = List.of(str.split(" "));
        System.out.println("\n" + "Строка после сплитования : " + "\n");
        for (String e : strings){

            System.out.println(e);
        }

        List<String> strAfter = filgerCapitalizedStrings(strings);

        System.out.println("\n" + "Строка после преобразования : " + "\n");
        for (String e : strAfter){

            System.out.println(e);
        }
    }
}
