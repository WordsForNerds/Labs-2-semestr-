import java.util.*;
import java.util.stream.Collectors;

public class Task7 {

    //Создаём функцию для фильтрации строк
    public static List<String> bolse (List<String> list, int num){

        return list.stream()
                //Если длина строки больше заданного значения. то мы записываем её в результирующий список
                .filter ( s -> s.length() > num)
                .collect (Collectors.toList());
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        //Сюда мы запишем выбор пользователя
        int num;

        String str = "Напишите функцию, которая принимает на вход список " +
                "строк и возвращает новый список, Содержащий только те строки, " +
                "которые начинаются с большйо буквы.";

        //Разделяем строку и выводим
        List<String> strings = List.of(str.split(" "));
        System.out.println("\n" + "Строка после сплитования : " + "\n");
        for (String e : strings){

            System.out.println(e);
        }

        System.out.println("Напишите целое число, которое станет мерилом: ");
        num = scan.nextInt();

        List<String> strAfter = bolse(strings, num);

        System.out.println("\n" + "Строка после преобразования : " + "\n");
        for (String e : strAfter){

            System.out.println(e);
        }
    }
}
