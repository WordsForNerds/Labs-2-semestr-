package Task1;

public class Example2 {

    public static void m(int x){

        if ((2 * x + 1) < 20){

            m(2 * x + 1);

        }
        System.out.println("x= " + x);

    }
    //Тут уже он выводит в обратном порядке, так как мы берём значения X уже при взовращении из рекурсии

    public static void main(String[] args){

        m(1);

    }

}
