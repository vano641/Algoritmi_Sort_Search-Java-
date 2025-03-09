/* Двусвязный список представляем из себя цепочку элементов которые
 * ссылаются не следующий и на предидущий элементы
 * 
 * pushBack класса List для добавления в конец двусвязного списка
 * popBack класса List для удаления в конец двусвязного списка
 * pushFront вставка в начало Двусвязного списка
 * popBack удаление из начала Двусвязного списка
 */

package Seminar3_Linked_lists;

public class Doubly_linked_list {
    public static void main(String[] args) {
//        List4 list1 = new List4();
        List4 list2 = new List4();
        for (int i = 10; i >= 1; i--) {
//            list1.pushFront(i);
            list2.pushBack(i);
        }
/*        list1.print(); // 54321
        list2.print(); // 12345

        list1.popFront();
        list1.print(); // 4321

        list2.popBack();
        list2.print();
*/
        list2.sort();
        list2.print();
    }
}

class List4 {  

    Node head;
    Node tail;

    class Node {
        int value;
        Node next;
        Node previous; 
    }

// Вставка в начало
    public void pushFront(int value){
        Node node = new Node();
        node.value = value;
        if (head == null) { // если список пустой
            tail = node;
        } else {
            node.next = head; // наш элемент ссылается на бывший первый
            head.previous = node; // вставляем в начало нашу ноду
        }
        head = node; // первым становится наша Нода
    }

// Удаление из начала
    public void popFront(){
        if (head != null) {
            if (head.next == null) { // если всего 1 элемент
                head = null;
                tail = null;
            } else {
                head = head.next; // заменяем Первый элемент на следующий
            }
        }
    }

// Вставка в Конец
    public void pushBack(int value){
        Node node = new Node();
        node.value = value;

        if (tail == null) { // если список пустой
            head = node;
            tail = node;
        } else {
            tail.next = node; // добавляем в конец
            node.previous = tail; // у нашей Ноды предидущей элемент равен старому Концу
        }
        tail = node; // меняем конец
    }

// Удаление из конца (Не работает почему то)
    public void popBack(){
        if (tail != null) {
            if (tail.previous == null) { // список из 1ого элемента
                head = null;
                tail = null;
            } else {
                tail = tail.previous; // меняем значение конца на предидущий
            }
        }
    }

// Печать
    public void print(){
        Node current = head;
        while (current != null) {
            System.out.printf("%d ", current.value);
            current = current.next;
        }
        System.out.println();
    }

// Пузырьковая сортировка
    public void sort(){
        boolean needSort = true;
        do {
            needSort = false;
            Node node = head; // начальная нода
            while (node != null && node.next != null){ // проходим до предпоследней позиции(чтобы всегда было 2 ноды для сравнения)
                if (node.value > node.next.value) { // меняем местами (обьекты)
                    Node before = node.previous; // ссылка до пары сравнения
                    Node current = node; // текущая нода
                    Node nextT = node.next; // нода справа с которой меняемся
                    Node after = node.next.next; // нода после нашей пары
// меняем ссылки у нод еоторые меняются местами(current, nextT)
                    current.previous = nextT; // 
                    current.next = after;
                    nextT.previous = before;
                    nextT.next = current;

                    if (before != null) {
                        before.next = nextT;
                    } else{
                        head = nextT;
                    }

                    if (after != null) {
                        after.previous = current;
                    } else{
                        tail = current;
                    }
                    needSort = true;
                }
                node = node.next;
            }

        }while(needSort);
    }

}
