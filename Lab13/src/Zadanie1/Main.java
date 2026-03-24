package Zadanie1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int sred;
        int sum = 0;

        //Заполняем массив числами
        System.out.println("Введите количество элементов массива: ");
        int[] nums = new int[scan.nextInt()];
        scan.nextLine();

        while (true){

            for (int i = 0; i < nums.length; i++){

                System.out.println("Введите значение ячейки № " + (i + 1));
                while(true){

                    String str = scan.nextLine();

                    try {

                        //Ввод строки вместо числа или несоответсвие числовому типу данных
                        int num = Integer.parseInt(str);

                        //Ввод отрицательного числа
                        if(Integer.parseInt(str) < 0){

                            throw new IllegalArgumentException();
                        }

                        nums[i] = Integer.parseInt(str);
                        //Сразу получаем сумму всех чисел при их записи в массив, чтобы потом найти среднее
                        sum += nums[i];
                        break;
                    } catch (IllegalArgumentException e){

                        System.out.println("Ошбика! " + e );
                        System.out.println("Введите корректное значение! Оно должно быть целым положительным числом.");
                    }
                }
            }
            break;
        }
        sred = sum / nums.length;
        System.out.println("Программа была успешно выполнена, ваше сренее значение: " + sred);
    }
}
