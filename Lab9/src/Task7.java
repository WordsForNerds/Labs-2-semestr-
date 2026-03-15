import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

import static java.nio.file.Files.size;

public class Task7 {

    public static class ListMethods{

        public void arrayList (int count){

            //Переменная, чтобы корректно вычёркивать из списка элементы
            int b = 1;
            int arrSize = 0;

            //Создаём лист с введённым количесвом участников
            ArrayList<Integer> arrayCircle = new ArrayList<>(count);

            //Заполняем его цифрами от 1 до i после чего выводим их на экран
            for (int i = 1; i <= count; i++){

                arrayCircle.add(i);
                System.out.println(arrayCircle.get(i - 1));
            }
            System.out.println(" ");
            //Это нужно, чтобы немного притормозить вывод
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (arrayCircle.size() != 1){

             /*   Так как список будет динамически уменьшаться, то я не могу напрямую указать его размер в цикле for,
                так как из за этого он не пройдётся по всем элементам, так же мне приходится создавать переменную
                b для того, чтобы удалять нужный элемент, ведь он при каждом новом удалении будет смещаться на -1
                индекс назад, поэтому я прибавляю к b единичку каждое удаление элемента, таким образом я просто
                заранее записываю количество элементов, после чего прохожусь по каждому из них и удаляю с учётом
                сдвига*/
                arrSize = arrayCircle.size();
                for (int i = 1; i <= arrSize; i++){

                    if (i % 2 == 0){

                        arrayCircle.remove(i - b);
                        b++;
                    } else {

                        System.out.println(arrayCircle.get(i - b));
                    }

                }
                System.out.println(" ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b = 1;
            }

            System.exit(0);
        }

        public void linkedList (int count){

            int b = 1;
            int arrSize = 0;

            LinkedList<Integer> arrayCircle = new LinkedList<>();

            for (int i = 1; i <= count; i++){

                arrayCircle.add(i);
                System.out.println(arrayCircle.get(i - 1));
            }
            System.out.println(" ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (arrayCircle.size() != 1){

                arrSize = arrayCircle.size();
                for (int i = 1; i <= arrSize; i++){

                    if (i % 2 == 0){

                        arrayCircle.remove(i - b);
                        b++;
                    } else {

                        System.out.println(arrayCircle.get(i - b));
                    }

                }
                System.out.println(" ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b = 1;
            }

            System.exit(0);
        }

    }

    public static void main (String[] args){


        Scanner scan = new Scanner(System.in);
        ListMethods listMethods = new ListMethods();
        System.out.println("Какой класс для выполнения этого задания вы хотите использовать ?");
        System.out.println("1. ArrayList");
        System.out.println("2. LinkedList");

        switch (scan.nextInt()){

            case 1:

                System.out.println("Введите количество человек в кругу (желательно немного, чтобы было наглядно видно вычёркивание)");
                listMethods.arrayList(scan.nextInt());
                break;
            case 2:

                System.out.println("Введите количество человек в кругу (желательно немного, чтобы было наглядно видно вычёркивание)");
                listMethods.linkedList(scan.nextInt());
                break;
        }
    }
}
