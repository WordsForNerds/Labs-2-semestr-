import java.util.Arrays;

public class Example6 {

    private static final Object lock = new Object();

    //Эту переменную я буду исопльзовать как счётчик позиции в массиве
    private static int number = 0;
    //Создаём массив и переменную, куда будем складывать сумму
    static int [] nums = {1,2,3,4,56,124,985,3,2,1};
    static int sum = 0;

    public static void main(String[] args){

        System.out.println(Arrays.toString(nums));

        Thread evenThread = new Thread(() -> {

            //Ключевое слово synchronized в Java означает, что блок кода или метод может выполняться
            // только одним потоком одновременно.
            synchronized (lock){

                while (number < nums.length){

                    //Этот поток будет обрабатывать только чётные позиции массива
                    if (number % 2 == 0){

                        sum += nums[number];
                        System.out.println(Thread.currentThread().getName() + "Сумма первого потока на данны момент: " + sum);
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

                        sum += nums[number];
                        System.out.println(Thread.currentThread().getName() + "Сумма второго потока на данны момент: " + sum);
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
                System.out.println("\n" + "Сумма всех чисел этого массива: " + sum);
            }
        });

        evenThread.setName("Even Thread");
        oddThread.setName("Odd Thread");

        evenThread.start();
        oddThread.start();
    }
}
