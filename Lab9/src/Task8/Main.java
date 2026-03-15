package Task8;

import java.util.Scanner;

public class Main {

    //Эта переменная содержит количество узлов
    public static int count = 0;

    public static void main(String[] args){

        //Создаём объекты сканнера и класса для работы с методам листа
        Scanner scan = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();

        //Буферная переменная, которая содержит выбор пользователя в данный момент
        int choice;

        System.out.println("\n" + "Я создал односвязный линейный список с нулём элементов");
        System.out.println("Пожалуйста, вводите только цифры, это сделано для облегчения моей работы");
        System.out.println("Какие действия вы хотите с ним сделать ? (Введите цифру нужного дейсвтия) " + "\n");

        while (true) {
            //Выводим варианты выбора для пользователя
            System.out.println("1. Ввод с головы" + "\n" + "2. Ввод с хвоста" + "\n" + "3. Вывод" + "\n" +
                    "4. Добавление элемента в начало списка" + "\n" + "5. Добавление элемента в конец списка" + "\n" +
                    "6. Вставка элемента в список с указанным номером" + "\n" + "7. Удаление элемента с головы списка"
                    + "\n" + "8. Удаление последнего элемента списка" + "\n" + "9. Удаление элемента из списка с указанным номером"
                    + "\n" + "10. Вводы с головы ( с использованием рекурсии )" + "\n" + "11. ввод с хвоста ( с использованием рекурсии)"
                    + "\n" + "12. Вывод ( с использованием рекурсии )" + "\n" );
            System.out.println("Введите цифру: ");

            //Обрабатываем выбор пользователя
            switch (scan.nextInt()) {

                case 1: //Ввод с  головы
                    System.out.println("Введите значение нового элемента с головы: ");

                    linkedList.createHead(scan.nextInt());
                    count++;
                    break;
                case 2: //Ввод с хвоста
                    System.out.println("Введите значение нового элемента с хвоста: ");

                    linkedList.createTail(scan.nextInt());
                    count++;
                    break;
                case 3: //Вывод

                    if (count < 1){

                        System.out.println("В списке нет элементов, выводить нечего!" + "\n");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                    linkedList.listToString();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                    break;
                case 4: //Добавление эелмента в начало списка
                    System.out.println("Введите значение нового элемента в начало списка: ");

                    linkedList.addFirst(scan.nextInt());
                    count++;
                    break;
                case 5: //Добавление эелмента в конец списка
                    System.out.println("Введите значение нового элемента в конец списка: ");

                    linkedList.addLast(scan.nextInt());
                    count++;
                    break;
                case 6: //Вставка элемента в список с указанным номером
                    System.out.println("Введите номер элемента в который вы хотите записать новую информацию: ");

                    choice = scan.nextInt();
                    if (choice < 1 || choice > count){

                        System.out.println("Элемента с таким номером нет в списке!" + "\n");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    System.out.println("Введите новую информацию для этого элемента");
                    linkedList.insert(choice, scan.nextInt());
                    break;
                case 7: //Удаление элемента с головы списка

                    linkedList.removeFirst();
                    count--;
                    break;
                case 8: //Удаление последнего элемента списка

                    linkedList.removeLast();
                    count--;
                    break;
                case 9: //Удаление из списка с указанным номером
                    System.out.println("Введите номер элемента который вы хотите удалить: ");

                    choice = scan.nextInt();
                    if (choice < 1 || choice > count){

                        System.out.println("Элемента с таким номером нет в списке!" + "\n");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                    linkedList.remove(choice);
                    count--;
                    break;
                case 10: //Ввод с головы (рекурсия)
                    System.out.println("Введите значение нового элемента с головы (рекурсия): ");

                    linkedList.createHeadRec(scan.nextInt());
                    count++;
                    break;
                case 11: //Ввод с хвоста (рекурсия)
                    System.out.println("Введите значение нового элемента с хвоста (рекурсия): ");

                    linkedList.createTailRec(scan.nextInt());
                    count++;
                    break;
                case 12: //Вывод (рекурсия)

                    if (count < 1){

                        System.out.println("В списке вообще нет элементов, выводить нечего!" + "\n");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                    linkedList.listToStringRec();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                    break;

            }
        }

    }

}
