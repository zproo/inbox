package nowcoder.jianzhioffer.a.a13_代码完整性_调整数组顺序使奇数位于偶数前面;

/*
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的 相对位置 不变。
 *
 * */
public class Solution {

    /*
     * 要求：相对位置不变 => 排序具有稳定性
     * 维护两个指针left, right
     * */
    public void reOrderArray(int[] array) {
        // ================================================
        // 方法1： 没有达到相对位置不变的要求
//        int left = 0;
//        int right = array.length - 1;
//        while (left < right) {
//            // left向右移动，直至找到第一个偶数
//            while (left<right && array[left] % 2 != 0) {
//                left++;
//            }
//
//            // right向左移动，直至找到第一个奇数
//            while (left<right && array[right] % 2 != 1) {
//                right--;
//            }
//
//            if (left < right) {
//                swap(array, left, right);
//            }
//        }
        // ================================================
        // 方法2：类似冒泡算法，前偶后奇数就交换。（保证了稳定性的要求）
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    swap(array, j, j+1);
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        Solution s = new Solution();
        s.reOrderArray(arr);
        // 输出拍好顺序后的数组
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            System.out.println(i1);
        }
    }

}
