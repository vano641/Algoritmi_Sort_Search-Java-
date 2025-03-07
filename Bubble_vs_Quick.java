// Сравнить время работы Быстрой сортировки и Пузырьковой
// Для сравнения есть класс Date с методом getTime()

import java.util.Date;

public class Bubble_vs_Quick {
    public static void main(String[] args) {
        int N = 20000;
        int[] Array1 = new int[N];
        int[] Array2 = new int[N];
        for (int i = 0; i < N; i++) {
            Array1[i] = (int)(Math.random() * 100);
            Array2[i] = Array1[i];
        }

        Date start = new Date();
        Bubble_Sort(Array1);
        Date end = new Date();
        long time1 = end.getTime() - start.getTime();

        start = new Date();
        Quick_Sort(Array2);
        end = new Date();
        long time2 = end.getTime() - start.getTime();

        System.out.printf("Bubble = %d, Quick = %d%n", time1, time2);

// => Bubble = 453, Quick = 2 - Время работы в мили секундах. Очевидно превосходство Quick

        
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
