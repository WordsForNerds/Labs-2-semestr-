package Examples;

import java.util.Scanner;

public class Example1 {

    public static void main(String[] args){

        try {
            System.out.println("0");
            throw  new RuntimeException("Непроверяемая ошибка");
        } catch (RuntimeException e) { //Сгенерировано и перехвачено RuntimeException.
            System.out.println("1  "+ e);  // исключение обработано
        }
        System.out.println("2");

    }
}
//Когда бы бросаем ошибку, то можем либо оставить её и программа на ней же и остановится,
// а компилятор даже не будет проверять, что будет дальше, либо мы можем её обработать,
// чтобы программа шла дальше. То есть мы выббрасываем ошибку, а потом ловим и обрабатываем