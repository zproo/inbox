package nowcoder.jianzhioffer.a.a6_查找和排序_旋转数组的最小数字;

/*
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * */
public class Solution {

    public int minNumberInRotateArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int left = 0;
        int right = array.length - 1;
        int mid = left;

        // 当low和up两个指针相邻时候，就找到了最小值，
        // 也就是右边序列的第一个值
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            // 如果low、up、mid下标所指的值恰巧相等
            // 如：{0,1,1,1,1}的旋转数组{1,1,1,0,1}
            // 此时这种方法无效，使用常规的顺序查找法
            if (array[left] == array[right]
                    && array[left] == array[mid]) {

                return minInOrder(array);
            }

            mid = left + (right-left) / 2;
            // 中间元素大于左边元素，属于递增数组中
            // 把左指针指向该中间元素
            if (array[mid] >= array[left]) {
                left = mid;
            } else if (array[mid] <= array[right]) {
                right = mid;
            }
        }
        return array[mid];
    }

    // 顺序查找法找到最小元素
    private int minInOrder(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {

            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

}
