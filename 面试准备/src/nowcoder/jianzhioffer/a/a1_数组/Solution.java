package nowcoder.jianzhioffer.a.a1_数组;

/*
* 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
* 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
* */
public class Solution {

    // 遍历数组的每一列，使用二分查找法逐行查找
    public boolean Find(int target, int[][] array) {

        for (int i = 0; i < array.length; i++) {
            int left = 0;
            int right = array[i].length-1;
            // 二分查找
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (array[i][mid] > target) {
                    right = mid - 1;
                } else if (array[i][mid] < target) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr;
        arr = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};


        System.out.println(solution.Find(7, arr));

    }
}
