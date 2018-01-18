package priv.zj.algorithm.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5};
        funBubbleSort(a);
        // 输出拍好顺序后的数组
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.println(i1);
        }
    }


    // 冒泡排序 注意 flag 的作用
    static void funBubbleSort(int[] array) {
        boolean flag = true;

        for (int i = 0; i < array.length - 1 && flag; i++) {
            flag = false;

            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    // 如果在某次遍历中没有发生交换，那么就不必进行下次遍历，因为序列已经有序。
                    flag = true;
                }
            }
        }
    }

    // 交换数组元素
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
