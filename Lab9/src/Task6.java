import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;


public class Task6 {

        public static void main (String[] args){

            Map<Integer,String> clientIds = new HashMap<>();
            int sum = 1;

            clientIds.put(1, "Pasha");
            clientIds.put(2, "Artem");
            clientIds.put(3, "Ulia");
            clientIds.put(4, "Vladimir");
            clientIds.put(5, "Elexandr");
            clientIds.put(6, "Nicola");
            clientIds.put(7, "Victor");
            clientIds.put(8, "Lidia");
            clientIds.put(9, "Arseniy");
            clientIds.put(10, "Nastya");

            System.out.println("Вот весь список: " + "\n");
            System.out.println(clientIds);

            System.out.println("\n" + "Поиск строк у которых айди больше чем 5");

            for (int i = 1; i <= clientIds.size(); i++){

                if (i > 5){

                    System.out.println(clientIds.get(i));
                }
            }
            System.out.println("\n" + "Поиск ключей где длина строки больше чем 5 с последующим их перемножением");
            for (int i = 1; i <= clientIds.size(); i++){

                if (clientIds.get(i).length() > 5){

                    sum *= i;
                }
            }
            System.out.println("Произведение равно: " + sum);

        }
}
