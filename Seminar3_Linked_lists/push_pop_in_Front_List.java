/* Метод pushFront класса List для добавление в начало списка
 * Метод popFront класса List для удаления из начала списка
 */
package Seminar3_Linked_lists;

public class push_pop_in_Front_List {
    public static void main(String[] args) {
        List1 list = new List1();
        for (int i = 1; i <= 5; i++) {
            list.pushFront(i);
        }

        list.print(); //54321 изначальны список

        list.popFront(); // удалили первый элемент
        list.popFront(); // еще раз удалили первый элемент

        list.print(); // 321
    }
}

class List1 {  

    Node head;

    class Node {
        int value;
        Node next; 
    }

    public void pushFront(int value){ // новая нода со значением value
        Node node = new Node(); // новая нода
        node.value = value; // присваиваем ей входной параметр
        node.next = head; // помещая элемент в начало, у нашей ноды
// ссылка на след. становится старым начальным элементом
        head = node; // а сам начальный элемент становится нашей нодой
    }

    public void popFront(){
        if (head != null) {
            head = head.next; // заменяем ссылку первого эл-та на след.
        }
    }

// метод печати списка
    public void print(){
        Node current = head;
        while (current != null) {
            System.out.printf("%d", current.value);
            current = current.next;
        }
        System.out.println();
    }
}    

