import java.sql.SQLOutput;
import java.util.*;

public class Task2 {

    public static int[] findCommonElements (int [] arr1, int [] arr2){

        return Arrays.stream(arr1)
                .filter(x -> Arrays.stream(arr2)
                .anyMatch(y -> y == x))
                .toArray();
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Введите размер массива: 3");
        int size = scan.nextInt();

        int [] arr1 = new int [size];
        int [] arr2 = new int [size];

        for ( int i = 0 ; i < size; i++){

            arr1[i] = rnd.nextInt(200);
            arr2[i] = rnd.nextInt(200);
        }

        System.out.println("Массив arr1: ");
        System.out.println(Arrays.toString(arr1));
        System.out.println("Массив arr2: ");
        System.out.println(Arrays.toString(arr2));

        int [] arrResult = findCommonElements(arr1,arr2);

        System.out.println("Массив arrResult: ");
        System.out.println(Arrays.toString(arrResult));
    }
}
