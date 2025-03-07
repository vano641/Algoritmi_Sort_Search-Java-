// На вход поступает целое число N из отрезка [1;1000] и массив из N целых чисел
// Написать алгоритм Быстрой сортировки

public class quickSort {
    public static void main(String[] args) {
        int N = 10;
        int[] Array = new int[N];
        for (int i = 0; i < N; i++) {
            Array[i] = (int)(Math.random() * 100);
            System.out.printf(" %d", Array[i]);
        }

        System.out.println();
        Quick_Sort(Array);
        
        for (int i = 0; i < N; i++) {
            System.out.printf(" %d", Array[i]);
        }
    }
// метод который вызывает пользователь от массива
    public static void Quick_Sort(int[] Array){
        QuickSort(Array, 0, Array.length - 1);
    }


// метод с параметрами
    private static void QuickSort(int[] Array, int left, int right){
// индексы краев массива
        int i = left;
        int j = right;
        int pivot = Array[(left + right) / 2]; // находим середину

        do {
            while (Array[i] < pivot) { //пока элемент меньше опорного перебераем 
                i++;
            }
            while (Array[j] > pivot) { // поеп элемент больше опорного перебераем
                j--; // уменьшаем значение тюе идем к середине справа налево
            }
            if(i <= j){
                if (i < j) {
                    int temp = Array[i];
                    Array[i] = Array[j];
                    Array[j] = temp;
                }
                i++;
                j--;
            }
        }while(i <= j); // выполняем пока индексы не сойдутся

        if (left < j) {
            QuickSort(Array, left, j);
        }
        if (i <= right) {
            QuickSort(Array, i, right);
        }
    }
}
