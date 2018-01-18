package nowcoder.jianzhioffer.a.a7_diguihexunhuan;

/*
 * 定义：这个数列从第3项开始，每一项都等于前两项之和。(前两个数为1)
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 * */
public class Solution {

    public int Fibonacci(int n) {

        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Fibonacci(10));
    }
}
