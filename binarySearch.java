// Дано число N и упорядоченный массив N из целых чисел
// Для числа К нужно найти позицию в массиве, на которой находится значение К

public class binarySearch {
    public static void main(String[] args) {
        int N = 100;
        int[] Array = new int[N];
        for (int i = 0; i < N; i++) {
            Array[i] = (int)(Math.random() * 100);
        }
        
        Bubble_Sort(Array);

        System.out.println(BinarySearch(Array, 42)); // возвращается номер позиции
    }

    public static Integer BinarySearch(int[] Array, int value){
// Реализуем Итнративный(он надежнее Рекурсивного) алогирм на while
        int left = 0, right = Array.length - 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (Array[mid] < value) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (Array[left] == value) {
            return left;
        }
        if (Array[right] == value) {
            return right;
        } 
        else{
        return -1;
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
