package nowcoder.jianzhioffer.a.a10;

/*
* 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
* 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
* */
public class Solution {

    /*
    * target = n 分为两步考虑：
    *   1. 第一次摆放一块 2*1 的小矩阵，则摆放方法总共为f(target - 1)
    *   2. 第一次摆放一块1*2的小矩阵，则摆放方法总共为f(target-2)
    * 因为，摆放了一块1*2的小矩阵（用√√表示），对应下方的1*2（用××表示）摆放方法就确定了，所以为f(targte-2)
    * */
    public int RectCover(int target) {
        if (target < 1) {
            return 0;
        }

        if (target == 1 || target == 2) {
            return target;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
}
