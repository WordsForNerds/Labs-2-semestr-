package Zadanie2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int size = 4;
        int column;
        //Создаём двумерный массив и выводим его пользователю
        int[][] nums = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
        };
        for (int i = 0; i < size; i++){

            for (int p = 0; p < size; p++){

                System.out.print("[" + nums[i][p] + "]");
            }
            System.out.println();
        }

        while (true){

            System.out.println("Введите номер столбца, который хотите вывести: ");
            String str = scan.nextLine();

            try {

                //Ввод строки вместо числа
                int num = Integer.parseInt(str);

                //Нет столбца с таким номером
                if (Integer.parseInt(str) > size || Integer.parseInt(str) < 1){

                    throw new ArrayIndexOutOfBoundsException();
                }
                column = Integer.parseInt(str) - 1;
                break;

            } catch (IllegalArgumentException e){

                System.out.println("Ошбика! " + e );
                System.out.println("Введите корректное значение! Это должно быть число!" + "\n");
            } catch (ArrayIndexOutOfBoundsException e){

                System.out.println("Ошбика! " + e );
                System.out.println("Введите корректное значение! Столбца с таким номером не существует!" + "\n");
            }
        };
        for (int i = 0; i < size; i++){

            System.out.println("[" + nums[i][column] + "]");
        }
    }
}
