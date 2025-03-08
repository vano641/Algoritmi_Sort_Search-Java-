/* Реализуем Односвязный список
    Класс Node для хранения  элементов списка
    Класс List для хранения списка элементов
 */
package Seminar3_Linked_lists;

class List { // 

    Node head; // сслыка на начало(головной элемент списка)

    class Node { // класс отвечает за "узлы" (описываем одну Ноду)
        int value; // значение элемента
        Node next; // т.к список односвязный нужна только одна ссылка
                   //на следующий элемент
    }    
}

public class Singly_Linked_List {
    public static void main(String[] args) {
        
    }
}
