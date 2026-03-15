package Task8;

import static Task8.Main.count;

public class LinkedList {

    /*LinkedList linkedList = new LinkedList();*/

    //Создаём узлы
    private class Node {

        private Node next = null;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    //Инициализируем значения головы и хвоста
    private Node head = null;
    private Node tail = null;


    //Добавление нового элемента в начало списка
    public void addFirst (int value){

        Node newNode = new Node(value);
        if (head == null){

            head = tail = newNode;
        } else {
          /*  Когда мы создаём в классе переменную, которая повторяет название класса,
            то мы создаём поле для самого класса, в котором можно что либо хранить,
            и создаём поле для каждого отдельного экземпляра этого класса.*/
          /*  В этих двух строках мы сначала обращаемся к полю только что созданного объекта
            (в нём харниться ссылка на следующий объект списка) и присваиваем ему новое значение
            из бывшей головы списка (так как мы добавляем его сверху и он по сути заменяет существующую голову)
            после чего присваиваем полю самого класса (head) новый узел, который теперь будет значится как новая
            голова.*/
            newNode.next = head;
            head = newNode;

        }
    }

    //Вывод всех элементов списка на экран
    public void listToString(){

        Node current = head;
        int i = 1;

        while (current != null){


            System.out.println(i + "." + " " + "Узел" + " " + current.value);
            current = current.next;
            i++;

        }
    }

    //Ввод с головы
    public void createHead (int value){

        Node newNode = new Node(value);
        if (head == null){

            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;

        }
    }

    //Добавление нового элемента с конца списка
    public void addLast(int value){

        Node newNode = new Node(value);
        if (head == null){

            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;

        }
    }

    //Ввод с хвоста
    public void createTail(int value){

        Node newNode = new Node(value);
        if (head == null){

            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;

        }
    }

    //Удаление элемента с головы списка
    public void removeFirst(){

        Node next = head.next;
        head.next = null;
        head = next;

    }

    //Ввод с головы (рекурсия) (Ей богу я не знаю как сделать этот вариант с рекурсией)
    public void createHeadRec (int value){

        Node newNode = new Node(value);
        if (head == null){

            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;

        }
    }

    //Удаление элемента с хвоста списка
    public void removeLast(){

        if(count == 1){

            removeFirst();
        } else {

            Node prev = head;
            /*Здесь мы передвигаемся от изначального элемента head (который мы поместили в prev),
            до предпоследнего ( узнаём мы это, когда следующий элемент от prev равняется хвосту
            (prev.next = tail)), после чего удаляем в предпоследнем элементе ссылку на следующий
            элемент и делаем его последним в списке.*/
            while (prev != null){

                if (prev.next == tail){

                    prev.next = null;
                    tail = prev;
                    break;
                }
                prev = prev.next;
            }
        }
    }

    //Ввод с хвоста (рекурсия) (аналогично как и с вводом с головы)
    public void createTailRec(int value){

        Node newNode = new Node(value);
        if (head == null){

            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;

        }
    }

    //Удаление из списка элемента с указанным номером
    public void remove(int numberElement){

        Node current = head;
        Node prev = head;

        if (numberElement == 1 ){

            removeFirst();
        }else if (numberElement == count){

           removeLast();
        } else {

            for (int i = 1; i < numberElement; i++){

                prev = current;
                current = current.next;
            }

            prev.next = current.next;
            current.next = null;
            return;
        }
    }

    //Вставка элемента в список с указанным номером
    public void insert(int numberElement, int value){

        Node current = head;
        for (int i = 1; i < numberElement; i++){

            current = current.next;
        }
        current.value = value;
        return;
    }

    //Вывод с использованием рекурсии
    public void listToStringRec(){

        listToStringRec1(head, 1);
    }

    //Предыдущий метод был вспомогательным для этого, потому что я не знаю как сделать это лучше
    public void listToStringRec1(Node current, int i){

        /*int i = 1;*/
        if (current == null){

            return;
        }

            System.out.println(i + "." + " " + "Узел" + " " + current.value);
            listToStringRec1(current.next, i + 1);

    }
}
