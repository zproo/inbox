package nowcoder.jianzhioffer.b.b13_时间空间效率的平衡_丑数;

import priv.zproo.others.Main;

import java.util.ArrayList;

/*
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * */
public class Solution {

    /*
    思路1：最简单的方法就是先通过将一个数不断除以2，3，5来判定该数是不是丑数，而后在从1开始，
    依次往后判断每个数是不是丑数，并记下丑数的个数，这样当计算的个数为给定值时，
    便是需要求的第n个丑数，这种方法的时间复杂度为O（k），这里的k为第n个丑数的大小，
    比如第1500个丑数的大小为859963392，那么就需要判断859963392次，时间效率非常低。
     */
    // 判断是否是丑数
    public boolean isUgly(int number) {

        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }

        return (number == 1) ? true : false;
    }

    public int getUglyNumber(int index) {

        if (index <= 0) {
            return 0;
        }

        int number = 0;
        int uglyFound = 0;

        while (uglyFound < index) {
            ++number;
            if (isUgly(number)) {
                uglyFound++;
            }
        }
        return number;
    }

    /*
    思路Better2：直观的优化措施就是看能不能将时间复杂度降低到O（n），
    即只在丑数上花时间，而不在非丑数上浪费时间。
    剑指offer上给的思路很好，用O（n）的辅助空间来得到O(n)的时间复杂度。
    其核心思想是：每一个丑数必然是由之前的某个丑数与2，3或5的乘积得到的，
    这样下一个丑数就用之前的丑数分别乘以2，3，5，找出这三这种最小的并且大于当前最大丑数的值，
    即为下一个要求的丑数。
    */
    public int GetUglyNumber_Solution(int index) {
        // 需要一个数组来装 从小到大的丑数
        if (index ==0) {
            return 0;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (res.size() < index) {
            int m2 = res.get(i2) * 2;
            int m3 = res.get(i3) * 3;
            int m5 = res.get(i5) * 5;

            int min = Math.min(m2, Math.min(m3, m5));
            res.add(min);

            if (min == m2) i2++;
            if (min == m3) i3++;
            if (min == m5) i5++;
        }

        return res.get(res.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        long startTime = System.currentTimeMillis();
//        int number = solution.getUglyNumber(1500);
        int number = solution.GetUglyNumber_Solution(1500);
        long endTime = System.currentTimeMillis();
        System.out.println( "花费时间 : " + (endTime-startTime) + "ms  " +number);

    }
}
