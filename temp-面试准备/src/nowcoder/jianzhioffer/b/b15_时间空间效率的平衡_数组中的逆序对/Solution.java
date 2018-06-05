package nowcoder.jianzhioffer.b.b15_时间空间效率的平衡_数组中的逆序对;


/*
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * */
public class Solution {

    /*
     * 思路：使用归并排序的思想，再归并中记录逆序对的个数
     *
     * */
    int reversePairNum = 0;

    public int InversePairs(int[] array) {

        if (array == null) {
            return 0;
        }
        int len = array.length;
        sort(array, 0, len - 1);
        return reversePairNum;
    }

    public void sort(int[] array, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public void merge(int[] array, int left, int mid, int right) {
        int len = right - left + 1;
        int[] aux = new int[len];

        int i = left, j = mid + 1;
        for (int k = 0; k < len; k++) {

            if (i > mid) {
                aux[k] = array[j];
                j++;
            } else if (j > right) {
                aux[k] = array[i];
                i++;
            } else if (array[i] <= array[j]) {
                aux[k] = array[i];
                i++;
            } else {
                aux[k] = array[j];
                j++;
                // 关键代码：因为后面数组的数字跳过了前面数组剩余的数字，剩余多少个就是多少的逆序对
                // 因为merge的时候前后都是已经 从小到大 排好顺序的
                reversePairNum += mid - i + 1;
                // 避免逆序对数量过多 溢出
                if (reversePairNum > 1000000007) {
                    reversePairNum %= 1000000007;
                }
            }
        }

        // 将合并后的数组复制回原数组
        for (int k = 0; k < aux.length; k++) {
            array[left + k] = aux[k];
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 8, 6, 7, 9, 1, 5};
        Solution solution = new Solution();
        solution.sort(array, 0, array.length - 1);

        // 输出拍好顺序后的数组
        for (int i = 0; i < array.length; i++) {
            int i1 = array[i];
            System.out.println(i1);
        }
    }


}
