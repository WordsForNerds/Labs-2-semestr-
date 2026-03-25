import java.util.Arrays;

public class Example5 {

    private static final Object lock = new Object();

    //Эту переменную я буду исопльзовать как счётчик позиции в массиве
    private static int number = 0;
    //Создаём массив и переменную, которая будет хранить наибольшее число
    static int [] nums = {1,2,3,4,56,124,985,3,2,1};
    static int max = 0;

    public static void main(String[] args){

        System.out.println(Arrays.toString(nums));

        Thread evenThread = new Thread(() -> {

            //Ключевое слово synchronized в Java означает, что блок кода или метод может выполняться
            // только одним потоком одновременно.
            synchronized (lock){

                while (number < nums.length){

                    //Этот поток будет обрабатывать только чётные позиции массива
                    if (number % 2 == 0){

                        if (nums[number] > max){

                            max = nums[number];
                        }
                        System.out.println(Thread.currentThread().getName() + "Максимальное число, что нашёл первый поток на данный момент: " + max);
                        number++;
                    } else {

                        try {

                            lock.wait();
                        } catch (InterruptedException e) {

                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        });

        Thread oddThread = new Thread(() -> {

            synchronized (lock){

                while (number < nums.length){

                    //Этот поток будет обрабатывать только нечётные позиции массива
                    if (number % 2 != 0){

                        if (nums[number] > max){

                            max = nums[number];
                        }
                        System.out.println(Thread.currentThread().getName() + "Максимальное число, что нашёл второй поток на данный момент: " + max);
                        number++;
                    } else {

                        try {

                            lock.wait();
                        } catch (InterruptedException e) {

                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
                System.out.println("\n" + "Максимальное число в этом массиве: " + max);
            }
        });

        evenThread.setName("Even Thread");
        oddThread.setName("Odd Thread");

        evenThread.start();
        oddThread.start();
    }
}
