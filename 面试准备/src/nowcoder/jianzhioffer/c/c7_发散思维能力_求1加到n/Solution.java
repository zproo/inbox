package nowcoder.jianzhioffer.c.c7_发散思维能力_求1加到n;

/*
 *求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字
 * 及条件判断语句（A?B:C）。
 * */
public class Solution {

    /*
    * 解题思路：https://www.nowcoder.com/profile/844008/codeBookDetail?submissionId=1522794
1.需利用逻辑与的短路特性实现递归终止。
2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
    * */

    public int Sum_Solution(int n) {

        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
