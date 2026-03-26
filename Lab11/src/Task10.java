import java.util.*;
import java.util.stream.Collectors;

public class Task10 {

    public static List<Integer> mense(List<Integer> list, int num){

        return list.stream().filter (x -> x < num).collect(Collectors.toList());
    }

    public static void main(String[] args){

        List<Integer> integers = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();
        int choice;

        System.out.println("\n" + "Список до: " + "\n");

        for ( int i = 0;  i < 10; i++){

            integers.add(rnd.nextInt(1000));
            System.out.println(integers.get(i));
        }
        System.out.println("Напишите целое число, которое станет мерилом: ");
        choice = scan.nextInt();

        List<Integer> integersAfter = mense(integers, choice);

        System.out.println("\n" + "Числа, которые меньше чем указанное: " + "\n");

        for (Integer i : integersAfter){

            System.out.println(i);
        }
    }
}
