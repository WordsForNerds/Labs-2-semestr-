public class Task4 {

    static class Node { //СТРУКТУРА ЭЛЕМЕНТА СПИСКА

        public int value; //значение
        public Node next; //Указатель на следующий узел (ссылка)

        Node (int value, Node next){
            this.value = value;
            this.next = next;

        }
    }

        public static void main(String[] args){

            Node node0 = new Node(0,null); //0-й узел будет головой с списке
            Node node1 = new Node(1,null);
            Node node2 = new Node(2,null);
            Node node3 = new Node(3,null); // Последний узел будет хвостом в списке

            //Связывание узлов при помощи ссылок
            node0.next = node1;
            node1.next = node2;
            node2.next = node3;

            //Вывод списка с использованием вспомогательной переменной ref
            //Соответствующей текущему значению ссылки при прохождении по списку
            Node ref = node0; //Для перемещения по списку достаточно помнить голову

            while (ref != null){

                System.out.println(" " + ref.value);
                ref = ref.next;

            }

        }


}
