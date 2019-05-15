package priv.zproo.myalgo.sorting.quicksort;

/*
 * 快速排序
 *
 * */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 4, 0};
        funQuickSort(a, 0, a.length - 1);
        // 输出拍好顺序后的数组
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.println(i1);
        }
    }

    static void funQuickSort(int[] array, int start, int end) {
        if (end > start) {
            int pivotIndex = partition1(array, start, end);
            funQuickSort(array, start, pivotIndex - 1);
            funQuickSort(array, pivotIndex + 1, end);
        }
    }


    // 1. 基础快速排序，选定第一个元素作为枢纽
    static int partition0(int[] array, int left, int right) {
        int pivot = array[left];
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (array[i] < pivot) {
                j++;
                swap(array, j, i);
            }
        }

        swap(array, left, j);

        return j;
    }

    // 2. 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    static int partition1(int[] array, int left, int right) {
        // 随机一个数与第一个交换，作为枢纽（避免近乎有序数列的情况）
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(array, left, (int) (Math.random() * (right - left + 1)) + left);

        int pivot = array[left];
        int i = left + 1;
        int j = right;

        while (true) {
            while (i <= right && array[i] < pivot) i++;
            while (j >= left + 1 && array[j] > pivot) j--;

            if (i > j) break;

            swap(array, i, j);
            i++;
            j--;
        }

        swap(array, left, j);
        return j;
    }


    static int partition(int[] list, int first, int last) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;

        while (high > low) {
            while (low <= high && list[low] <= pivot) {
                low++;
            }

            while (low <= high && list[high] > pivot) {
                high--;
            }

            if (high > low) {
                swap(list, low, high);
            }
        }

        while (high > first && list[high] >= pivot) {
            high--;
        }

        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    // 交换数组元素
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
