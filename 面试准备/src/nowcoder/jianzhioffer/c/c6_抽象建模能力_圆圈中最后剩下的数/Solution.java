package nowcoder.jianzhioffer.c.c6_抽象建模能力_圆圈中最后剩下的数;

import java.util.ArrayList;

/*
* 题目描述：一个环，每次删除第m个数字，求最后一个数字，
* 如0，1，2，3，4这5个数字，从0开始每次删除第3个数字，
* 则依次删除2，0，4，1，最后一个数字是3
* */
public class Solution {

    // ===============方法一：使用链表 O(N)===============
    public int LastRemaining_Solution(int n, int m) {

        if (n == 0 || m == 0) {
            return -1;
        }
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(i);
        }
        int index = -1;
        while (data.size() > 1) {
            // 关键代码
            index = (index + m) % data.size();
            data.remove(index); // 去掉第index个元素，后面的元素前移
            index--;
        }
        return data.get(0);
    }

    // ===============方法二：约瑟夫环经典解法 O(N) 空间O(1)===============
    public int LastRemaining_Solution2(int n, int m) {

        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;   // n=1时最后的数是0
        for (int i = 2; i <= n; i++) {

            last = (last + m) * i;
        }
        return last;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.LastRemaining_Solution(10, 3));

    }
}
