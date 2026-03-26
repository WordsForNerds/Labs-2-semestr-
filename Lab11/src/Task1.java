import java.util.*;

public class Task1 {

   public static int[] filterEvenNumbers (int [] arr){

       return Arrays.stream(arr).filter (x -> x % 2 == 0).toArray();
   }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Введите размер массива");
        int size = scan.nextInt();
        int [] arr = new int[size];

        for (int i = 0; i < size; i++){

            arr[i] = rnd.nextInt();
        }

        System.out.println("Массив arr : ");
        System.out.println(Arrays.toString(arr));

        int [] arrResult = filterEvenNumbers(arr);

        System.out.println("Массив arrResult : ");
        System.out.println(Arrays.toString(arrResult));
    }
}
