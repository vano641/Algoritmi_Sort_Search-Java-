/* Метод contains для поиска нужного элемента
 * Метод возвращает True/False в зависимости от того найден элемент или нет
 */
package Seminar3_Linked_lists;

public class find_element_List {
    public static void main(String[] args) {
        
        List2 list = new List2();
        for (int i = 1; i <= 5; i++) {
            list.pushFront(i);
        }
        list.print(); // 54321
        System.out.println(list.consist(2)); // true
        System.out.println(list.consist(9)); // false
    }
}

class List2 {  

    Node head;

    class Node {
        int value;
        Node next; 
    }

// Поиск
    public boolean consist(int value){
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

// Добавление
    public void pushFront(int value){
        Node node = new Node(); 
        node.value = value;
        node.next = head;
        head = node;
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
