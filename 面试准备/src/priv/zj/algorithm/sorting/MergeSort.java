package priv.zj.algorithm.sorting;

import java.util.Arrays;

/*
 * 归并排序
 * */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {3, 2, 8, 6, 7, 9, 1, 5};
        funMergeSort(array, 0, array.length - 1);

        // 输出拍好顺序后的数组
        for (int i = 0; i < array.length; i++) {
            int i1 = array[i];
            System.out.println(i1);
        }
    }


    // 分解操作
    static void funMergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            funMergeSort(array, left, mid); // 左边归并排序
            funMergeSort(array, mid + 1, right); // 左边归并排序
            merge1(array, left, mid, right); // 将两个子数组合并
        }

    }

    static void merge1(int[] array, int low, int mid, int high) {
        // temp数组下标从0开始
        int[] temp = Arrays.copyOfRange(array, low, high + 1);

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                array[k] = temp[j - low];
                j++;
            } else if (j > high) {
                array[k] = temp[i - low];
                i++;
            } else if (temp[i - low] < temp[j - low]) {
                array[k] = temp[i - low];
                i++;
            } else {
                array[k] = temp[j - low];
                j++;
            }
        }

    }

    // 合并操作（关键就是开辟一个临时空间）
    static void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0; // 临时合并序列的下标
        int[] temp = new int[high - low + 1]; // 临时合并序列

        // 扫描第一段和 第二段序列，直到有一个扫描结果
        while (i <= mid && j <= high) {
            // 判断第一段和第二段取出的数哪个更小，存入合并序列，并继续向下扫描
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                i++;
                k++;
            } else {
                temp[k] = array[j];
                j++;
                k++;
            }
        }

        // 若第一段还没有扫描完，将其全部复制到合并序列
        while (i <= mid) {
            temp[k] = array[i];
            i++;
            k++;
        }

        // 若第二段还没有扫描完，将其全部复制到合并序列
        while (j <= high) {
            temp[k] = array[j];
            j++;
            k++;
        }

        // 将合并序列复制到原始序列中
        for (k = 0, i = low; i <= high; i++, k++) {
            array[i] = temp[k];
        }
    }
}
