package Zadanie3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        byte sum = 0;
        Scanner scan = new Scanner(System.in);

        //Задаём размер массива
        System.out.println("Введите количество элементов массива: ");
        byte[] nums = new byte[scan.nextInt()];
        scan.nextLine();

        //Заставляем пользователя вводить числа до тех пор, пока он не справится с задачей
        while (true) {

            //Цикл, которая заполняет массив нормальными числами
            for (int i = 0; i < nums.length; i++) {

                System.out.println("Введите значение ячейки № " + (i + 1));

                while (true) {

                    String str = scan.nextLine();

                    try {

                        //Ввод строки вместо числа
                        int num = Integer.parseInt(str);

                        //Ввод значения за границами диапазона
                        if (Integer.parseInt(str) > 127 || Integer.parseInt(str) < -128) {

                            throw new IllegalArgumentException();
                        }

                        nums[i] = Byte.parseByte(str);
                        break;
                    } catch (IllegalArgumentException e) {

                        System.out.println("Ошбика! " + e );
                        System.out.println("Введите корректное значение! Оно должно быть числом от -128 до 127.");
                    }
                }
            }

            try {

                for (int i = 0; i < nums.length; i++){

                    //Вычисление значения за границами диапазона типа
                    if (sum + nums[i] > 127){

                        throw new ArrayIndexOutOfBoundsException();
                    }
                    sum += nums[i];
                }
                break;
            } catch (ArrayIndexOutOfBoundsException e){

                sum = 0;
                System.out.println("Ошбика! " + e );
                System.out.println("Введённые вами числа выходят за диапазон Byte");
                System.out.println("В наказание за это придётся заново их указать" + "\n");
            }
        }

        System.out.println("Программа была успешно выполнена, ваша сумма: " + sum);
    }
}
