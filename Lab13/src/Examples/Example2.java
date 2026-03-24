package Examples;

public class Example2 {

    public static void main(String[] args){

        int num = 3;

        try {
            System.out.println("0");
            System.out.println("1");
                throw new RuntimeException("Непроверяемая ошибка");
        } catch (Exception e) { //Исключение перехвачено перехватчиком предка.
            System.out.println("2 " + e);
        }
        System.out.println("3");

    }
}
