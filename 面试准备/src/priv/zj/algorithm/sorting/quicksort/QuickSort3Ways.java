package priv.zj.algorithm.sorting.quicksort;

public class QuickSort3Ways {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 4, 0};
        funQuickSort3Ways(a, 0, a.length - 1);
        // 输出拍好顺序后的数组
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.println(i1);
        }
    }

    // 3. 3路快速排序，不需要partition函数，递归函数就是本身
    // 递归使用快速排序,对arr[l...r]的范围进行排序
    static void funQuickSort3Ways(int[] array, int left, int right) {
        // 排序完成尾部处理
        if (right <= left) {
            return;
        }


        // 随机一个数与第一个交换，作为枢纽（避免近乎有序数列的情况）
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(array, left, (int) (Math.random() * (right - left + 1)) + left);

        int pivot = array[left];

        int lt = left; // lower than a[left+1...lt] < pivot
        int gt = right + 1; // greater than a[gt...right] > pivot
        int i = left + 1;

        while (i < gt) {
            if (array[i] < pivot) {
                swap(array, i, lt + 1);
                i++;
                lt++;
            } else if (array[i] > pivot) {
                swap(array, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }

        swap(array, left, lt);

        // 递归
        funQuickSort3Ways(array, left, lt - 1);
        funQuickSort3Ways(array, gt, right);
    }

    // 交换数组元素
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
