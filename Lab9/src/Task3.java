import java.util.Scanner;

public class Task3 {

    public static String[] arr = new String[3];
    public static int count= 0;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите три элемента массива, чтобы я вывел их на экран");
        vvod();
        System.out.println(" ");
        vivod();


    }

    public static void vvod(){


        if (count < 3){

            Scanner scan = new Scanner(System.in);

            arr[count] = scan.nextLine();
            System.out.println("Введён элемент массива: " + arr[count]);
            count++;
            vvod();

        }

    }

    public static void vivod(){

        if (count > 0){

            System.out.println("Выведен элемент массива: " + arr[count - 1] + " " + "под номером - " + count);
            count--;
            vivod();


        }

    }
}
