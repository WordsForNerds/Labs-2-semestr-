import java.util.*;
import java.util.stream.Collectors;

public class Task9 {

    public static void viborka2 (List<String> list, String [] arr){

        for (int i = 0; i < list.size(); i++){

            for (int v = 0; v < arr.length; v++){

                if (list.get(i).contains(arr[v])){

                    System.out.println(list.get(i));
                    break;
                }
            }
        }
    }

    public static void main(String[] args){

        String [] arr = {"а","б","в","г","д","е","ё","ж","з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х","ц","ч","ш","щ","ъ","ы","ь","э","ю","я"};

        String string = "Напи1шите функцию, кото4рая прини2мает на вх4од сп2сок " +
                "строк и возвр4ащает но12вый список, Содер24жащий тол4ько те стр4оки, " +
                "которые начин2аются с боль4шой буквы.";

        //Разделяем строку и выводим
        List<String> strings = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплитования : " + "\n");
        for (String e : strings){

            System.out.println(e);
        }


        System.out.println("Строки, которые содеражат только буквы без специальных символов и цифр");
        viborka2(strings, arr);

    }
}
