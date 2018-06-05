package nowcoder.jianzhioffer.c.c1_知识迁移能力_和为S的连续正数序列;

import java.util.ArrayList;

public class Solution {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (sum < 3) {

            return list;
        }
        ArrayList<Integer> subList = new ArrayList<>();
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;

        subList.add(small);
        subList.add(big);


        while (small < middle) {
            if (curSum == sum) {
                list.add(new ArrayList<Integer>(subList));
            }
            // 大于sum的时候，增加small
            while (curSum > sum && small < middle) {
                curSum = curSum - subList.remove(0);
                small++;

                if (curSum == sum) {
                    list.add(new ArrayList<Integer>(subList));
                }
            }

            // 在上一步中大于和等于sum情况已被过滤
            // curSum小于sum时，增大big
            big++;
            subList.add(big);
            curSum += big;
        }

        return list;
    }

}
