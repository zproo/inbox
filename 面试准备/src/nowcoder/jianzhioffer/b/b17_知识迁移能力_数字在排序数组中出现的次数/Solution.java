package nowcoder.jianzhioffer.b.b17_知识迁移能力_数字在排序数组中出现的次数;

/*
 * 统计一个数字在排序数组中出现的次数。
 * */
public class Solution {

    // 思路：利用二分查找找到第一次出现的坐标 和 最后一次出现的坐标
    public int GetNumberOfK(int[] array, int k) {

        int num = 0;
        int len = array.length - 1;
        if (array != null) {
            int firstIndex = getFirstKey(array, 0, len, k);
            int lastIndex = getLastKey(array, 0, len, k);
            if (firstIndex > -1 && lastIndex > -1) {
                num = lastIndex - firstIndex + 1;
            }
        }
        return num;
    }

    // 普通方法实现二分查找，
    // 找到第一个出现数字的下标
    public int getFirstKey(int[] array, int left, int right, int k) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midData = array[mid];

            if (midData == k) {

                //判断是不是第一个K，前一个不等于K，就是第一个K
                if ((mid > 0 && array[mid - 1] != k) || mid == 0) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (midData > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 普通方法实现二分查找，
    // 找到最后一个出现数字的下标
    public int getLastKey(int[] array, int left, int right, int k) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midData = array[mid];

            if (midData == k) {

                //判断是不是最后一个K，后一个不等于K，就是最后一个K
                if ((mid < right && array[mid + 1] != k) || mid == right) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (midData > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
