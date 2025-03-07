/*  На вход поступает целое число N из отрезка [1;1000] и массив из N целых чисел
    Написать алгоритм Пузырьковой сортировки
 */

public class bubbleSort {

    public static void main(String[] args) {
        int N = 10;
        int[] Array = new int[N];
        for (int i = 0; i < N; i++) {
            Array[i] = (int)(Math.random() * 100);
            System.out.printf(" %d", Array[i]);
        }

        System.out.println();
        Bubble_Sort(Array);
        
        for (int i = 0; i < N; i++) {
            System.out.printf(" %d", Array[i]);
        }
    }

// метод пузырьковой сортировки
    public static void Bubble_Sort(int[] array){
        boolean flag = true;

        do{
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    flag = true;
                }
            }
        }while(flag);
    }
}
