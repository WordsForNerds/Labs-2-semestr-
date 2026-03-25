public class Example4 {

    public static void main(String[] args){

        Thread t1 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName());
        });
        Thread t2 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName());
        });
        Thread t3 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName());
        });
        Thread t4 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName());
        });
        Thread t5 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName());
        });
        Thread t6 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName());
        });
        Thread t7 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName());
        });
        Thread t8 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName());
        });
        Thread t9 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName());
        });
        Thread t10 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName());
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}
