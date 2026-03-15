import java.util.Scanner;

public class Task2 {

    //Объявляю переменную здесь, чтобы она была доступна в методе
    public static String bin = "";

    public static void main(String[] args){


        Scanner scan = new Scanner(System.in);

        System.out.println("Введите число" + "\n");
        m(scan.nextInt());
        //Эта проверка нужна, чтобы если у нас число, которое больше нуля, то не было лишнего нуля в начале
        if ( bin != "0"){

            bin = bin.substring(1);
        }
        System.out.println("Вот ваше число в двоичном представлении: " + bin);


    }
    public static void m(int x){

        int ostatok = 0;

        if( x > 0){
            ostatok = x % 2;
            x = x / 2;
            m(x);


        }
        bin += ostatok;

    }
}
