package bobo.algo.heap_04.heap_sort_06.temp;

public class HeapSort {
    private HeapSort() {
    }

    public static void sort(Comparable[] arr) {
        // 先进行heapify操作
        int n = arr.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }

        // 然后不断的取出根节点
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i); // 位置0是第一个，即根节点，即最大值。放到数组最后
            shiftDown(arr, n, 0);
        }
    }

    private static void shiftDown(Comparable[] arr, int n, int k) {
        // 当该节点拥有左孩子的时候循环
        while (2 * k + 1 <= n) {
            int j = 2 * k + 1;
            // 右孩子大于左孩子时
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                j++;
            }

            if (arr[k].compareTo(arr[j]) >= 0) break;

            swap(arr, k, j);
            k = j;
        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("bobo.algo.heap_04.heap_sort_06.temp.HeapSort", arr);

        return;
    }
}
