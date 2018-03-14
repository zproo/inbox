package nowcoder.jianzhioffer.c.c2_知识迁移能力_和为S的两个数字;

import java.util.ArrayList;

/*
* 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
* 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
* */
public class Solution {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) {
            return list;
        }

        // 维护两个指针，一个指向数组最小元素，一个指向最大
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }
        }

        return list;
    }
}
