import java.util.*;
import java.util.stream.Collectors;

public class Task4 {

    public static List<Integer> squareList(List<Integer> list){

        return list.stream().map ( x -> x * x).collect(Collectors.toList());
    }

    public static void main(String[] args){

        List<Integer> integers = new ArrayList<>();
        Random rnd = new Random();

        System.out.println("\n" + "Список до: " + "\n");

        for ( int i = 0;  i < 10; i++){

            integers.add(rnd.nextInt(1000));
            System.out.println(integers.get(i));
        }

        List<Integer> integersAfter = squareList(integers);

        System.out.println("\n" + "Список после возведения в квадрат: " + "\n");

        for (Integer i : integersAfter){

            System.out.println(i);
        }
    }
}
