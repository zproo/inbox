package nowcoder.jianzhioffer.c.c5_抽象建模能力_扑克牌顺子;


import java.util.ArrayList;
import java.util.Collections;

/*
 * 从扑克牌中抽取5张牌，判断是否连续，大小王是任意数字
 * */
public class Solution {

    public boolean isContinuous(int[] numbers) {

        if (numbers == null || numbers.length == 0 || numbers.length > 5) {
            return false;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int count = 0;  // numbers中0的个数
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                count++;
            } else {
                arrayList.add(numbers[i]);
            }
        }

        // 对除去0的牌排序
        Collections.sort(arrayList);
        int len = arrayList.size();
        // 最小 最大相差大于4，肯定false
        if (Math.abs(arrayList.get(0) - arrayList.get(len - 1)) > 4) {
            return false;
        }
        for (int i = 0; i < len - 1; i++) {

            int diff = arrayList.get(i + 1) - arrayList.get(i);
            // 相邻的数满足： 1 大于0（等于0时相等 重复了） 2 小于5（大于4肯定不行）
            if (diff > 0 && diff < 5) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}
