/* pushBack класса List для добавления в конец списка
 * popBack класса List для удаления с конца списка
 */
package Seminar3_Linked_lists;

public class push_pop_Back_List {
    public static void main(String[] args) {
        List3 list = new List3();
        for (int i = 1; i <= 5; i++) {
            list.pushBack(i);
        }

        list.print(); // 12345

        list.popBack();
        list.print(); // 1234
    }
}

class List3 {  

    Node head;

    class Node {
        int value;
        Node next; 
    }

// Добавление в Конец Односвязного списка
    public void pushBack(int value){
        Node node = new Node();
        node.value = value;

        if (head == null) {
            head = node;
        } else{ // ищем элемент за которым ничего нет
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node; // к элементу у которого ссылка на nexh==null добавляем ноду за него
        }
    }

    public void popBack(){
        if (head != null) {
            if (head.next == null) { // если всего 1 элемент в списке
                head = null;
            } else {
                Node current = head;
                while (current.next.next != null) {
                    current = current.next;
                }
                current.next = null; // обнуляем последний элемент
            }
        }
    }

// Печать
    public void print(){
        Node current = head;
        while (current != null) {
            System.out.printf("%d", current.value);
            current = current.next;
        }
        System.out.println();
    }
}