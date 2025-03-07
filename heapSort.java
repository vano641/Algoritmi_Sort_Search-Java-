// Реализовать алгоритм пирамидальной сортировки (сортировка кучей).

public class heapSort {
    public static void main(String[] args) {
        int N = 10;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        for (int i = 0; i < N; i++) {
            System.out.printf(arr[i] + " ");
        }

        System.out.println();

        heap_Sort(arr);

        for (int i = 0; i < N; i++) {
            System.out.printf(arr[i] + " ");
        }

    }
        
    public static void heap_Sort(int[] arr){
        int n = arr.length;
// идем от середины массива до позиции начала массива (до корня)
        for (int i = n / 2 - 1; i >= 0; i--) { 
// передаем в метод(обновление бинарной кучи (балансировка)) 
// наш массив, размер n, балансируем узел(ячейку) i
            heapify(arr, n, i);
        }
// выполняем сам алгорим сортировки, пройти по всем элементам от конца
// и меняем с корневым(самый большой) и меняем на последнее место
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
// далее нужно обновить ответ в корне(вызываем футнкцию от корня)
// от массива arr и размер уменьшаем на 1 (i), балонсировку запускаем с 0 элемента
            heapify(arr, i, 0);
        }
    }

// метод балансировки кучи
    private static void heapify(int[] arr, int n, int i){
// n - размер кучи, i - корень
        int largest = i; // максимальный элемент
        int l = 2 * i + 1; // левый потомок от i
        int r = 2 * i + 2; // правый потомок от i

// проверяем потомков на то, что они больше чем максимальный элемент
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (i != largest) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, n, largest);
        }
    }
}
