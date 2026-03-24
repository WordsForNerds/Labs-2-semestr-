package Examples;

public class Example7 {

    public static void main(String[] args){

        try {

            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {

            System.out.println("1");
            try {

                throw new ArithmeticException();
            } catch (ArithmeticException f){

                System.out.println("2");
            }
        } finally {

            System.out.println("3");
        }

    }
}
