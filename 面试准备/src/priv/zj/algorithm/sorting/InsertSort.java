package priv.zj.algorithm.sorting;

/*
 * 直接插入排序
 *
 * */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5};
        funInsertSort1(a);
        // 输出拍好顺序后的数组
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.println(i1);
        }
    }

    /*
     * 方法1：直接插入排序 针对有序序列在插入时采用移动法
     *
     * */
    static void funInsertSort(int[] array) {
        int j;

        for (int i = 1; i < array.length; i++) {
            int temp = array[i]; // 要插入排序的数据
            j = i - 1; // 插入数据的前一个

            // 获得插入位置（从后往前对比，对比到第一个停止）
            while (j > -1 && temp < array[j]) {
                // 插入排序采用移动法
                array[j + 1] = array[j]; // 符合条件，被比较数据向后移
                j--; // 指针移到下一个对比元素
            }

            array[j + 1] = temp; // 将要插入数据插入最终位置
        }
    }

    /*
     * 方法2：直接插入排序 针对有序序列在插入时采用移动法
     *
     * */
    static void funInsertSort1(int[] array) {
        int j;

        for (int i = 1; i < array.length; i++) {
            int temp = array[i]; // 要插入的数据
            j = i - 1; // 插入数据的前一个

            // 获得插入位置（从后往前对比，对比到第一个停止）
            while (j > -1 && temp < array[j]) {
                // 插入排序采用交换法
                swap(array, j, j+1);
                j--; // 指针移到下一个对比元素
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
