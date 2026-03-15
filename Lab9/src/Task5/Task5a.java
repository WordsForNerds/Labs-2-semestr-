package Task5;

public class Task5a {

    static class Node { //СТРУКТУРА ЭЛЕМЕНТА СПИСКА

        public int value; //значение
        public Node next; //Указатель на следующий узел (ссылка)

        Node (int value, Node next){
            this.value = value;
            this.next = next;

        }
    }

    public static void main(String[] args){
        //Добавление элементов с перемещением головы (наращиванием элементов)
        Node head = null; //Начальное назначение ссылки на голову
        for (int i = 9; i >= 0; i--){

            head = new Node(i, head);

        }

        //Вывод элементов на экран
        Node ref = head;
        while (ref != null) {

            System.out.println(" " + ref.value);
            ref = ref.next;

        }



    }

}
