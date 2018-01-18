package nowcoder.jianzhioffer.a.a11_weiyunsuan;

/*
* 输入一个整数，输出该数二进制表示中1的个数。
* 其中负数用补码表示。
* */
public class Solution {

    /*
    * java中Integer函数的toBinaryString方法可以得到数字的二进制表示
    * */
    public int NumberOf1(int n) {
        char[] b = Integer.toBinaryString(n).toCharArray();
        int count = 0;

        for (int i = 0; i < b.length; i++) {
            if (b[i] == '1') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.NumberOf1(-5));

//        System.out.println(Integer.toBinaryString(-5));
    }
}
