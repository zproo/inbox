package nowcoder.jianzhioffer.a.a12_代码完整性_数值的整数次方;

/*
 * 代码的完整性	数值的整数次方
 *
 * 给定一个 double类型的浮点数base 和 int类型的整数exponent。
 * 求base的exponent次方。
 * */
public class Solution {

    // 由于exponent是int类型的整数，则可能包含正整数、0以及负整数三种情况。
    public double Power(double base, int exponent) {

        double temp = 1;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                temp = temp * base;
            }
            return temp;
        } else if (exponent < 0) {
            int a = -exponent;
            for (int i = 0; i < a; i++) {
                temp = temp * base;
            }
            return 1 / temp;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Power(2, 3));

    }
}
