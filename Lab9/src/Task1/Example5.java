package Task1;

public class Example5 {

    public static void main(String[] args){

        System.out.println(fib(7));
    }

    public static int fib(int n){

        if (n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else {
            System.out.println(n);
            return fib(n - 2) + fib(n - 1);
        }
    }

}
