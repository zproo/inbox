package priv.zproo.myalgo.sorting;

/*
 *  希尔排序
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，
 * 当增量减至1时，整个文件恰被分成一组，算法便终止。
 * */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 4, 0};
        funShellSort(a);
        // 输出拍好顺序后的数组
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.println(i1);
        }
    }

    /*
    * 希尔排序 针对有序序列在插入时采用移动法。
    * */
    static void funShellSort(int[] array) {
        // 增量gap，并逐步缩小增量
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < array.length; i++) {
                int temp = array[i]; // 要插入排序的数据
                int j = i;
                while (j - gap >= 0 && temp < array[j - gap]) {
                    // 移动法
                    array[j] = array[j - gap];
                    j = j- gap;
                }

                array[j] = temp;
            }
        }
    }

    /*
     * 希尔排序 针对有序序列在插入时采用交换法。
     * */
    static void funShellSort1(int[] array) {
        // 增量gap，并逐步缩小增量
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < array.length; i++) {
                int temp = array[i]; // 要插入排序的数据
                int j = i;
                while (j - gap >= 0 && temp < array[j - gap]) {
                    // 插入排序采用交换法
                    swap(array, j, j - gap);
                    j = j- gap;
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
