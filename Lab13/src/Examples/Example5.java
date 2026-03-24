package Examples;

public class Example5 {

    public static void main(String[] args){

        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) { //Исключение не перехвачено
            System.out.println("1");
        }
        System.out.println("2");

    }
}
