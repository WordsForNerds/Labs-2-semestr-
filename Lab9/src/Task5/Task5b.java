package Task5;

public class Task5b {

    static class Node { //СТРУКТУРА ЭЛЕМЕНТА СПИСКА

        public int value; //значение
        public Node next; //Указатель на следующий узел (ссылка)

        Node(int value, Node next) {
            this.value = value;
            this.next = next;

        }
    }

    public static void main(String[] args) {
        //Добавление элементов с перемещением головы (наращиванием элементов)
        Node head = null; //Начальное назначение ссылки на голову
        for (int i = 9; i >= 0; i--) {

            head = new Node(i, head);

        }
        Node newtail = new Node(123, null);
        Node ref = head;
        while (ref.next != null) { // пока не последний элемент
            ref = ref.next;
        }
        ref.next=newtail;


    }
}
