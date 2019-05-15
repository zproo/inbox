package nowcoder.jianzhioffer.b.b9_时间效率_最小的k个数;

import java.util.ArrayList;

/*
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * */
public class Solution {

    /*
    * 思路1：
经典常用的算法，快速排序的精髓利用快速排序划分的思想，
每一次划分就会有一个数字位于以数组从小到达排列的的最终位置index；

位于index左边的数字都小于index对应的值，右边都大于index指向的值；

所以，当index > k-1时，表示k个最小数字一定在index的左边，
       此时，只需要对index的左边进行划分即可；
当index < k - 1时，说明index及index左边数字还没能满足k个数字，需要继续对k右边进行划分；
    *
    * */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList arrayList = new ArrayList();
        if(input.length == 0 || k > input.length || k <= 0)
            return arrayList;
        int left = 0;
        int right = input.length - 1;
        int index = Partition(input, left, right);
        while (index != k - 1) {
            if (index > k - 1) {
                right = index - 1;
                index = Partition(input, left, right);
            } else {
                left = index + 1;
                index = Partition(input, left, right);
            }
        }

        // 将最小的k个数放入list并返回
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    public int Partition(int[] arr, int left, int right){
        // 默认取第一个元素进行比较
        int v = arr[left];

        int j = left;
        for (int i = left+1; i < arr.length; i++) {
            if (arr[i] < v) {
                j++;
                swap(arr, j, i);
            }
        }

        swap(arr, left, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
