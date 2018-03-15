package nowcoder.jianzhioffer.b.b7_分解让复杂问题简单_字符串的排列;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
* 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
* 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
* abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。
* */
public class Solution {




    /**
     * 对于无重复值的情况** 固定第一个字符，递归取得首位后面的各种字符串组合；
     * 再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
     * 递归的出口，就是只剩一个字符的时候，递归的循环过程，就是从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串。
     *
     * 假如有重复值呢？
     * 由于全排列就是从第一个数字起，每个数分别与它后面的数字交换，我们先尝试加个这样的判断——如果一个数与后面的数字相同那么这两个数就不交换了。
     * 例如abb，第一个数与后面两个数交换得bab，bba。然后abb中第二个数和第三个数相同，就不用交换了。
     *
     * 但是对bab，第二个数和第三个数不同，则需要交换，得到bba。
     * 由于这里的bba和开始第一个数与第三个数交换的结果相同了，因此这个方法不行。
     *
     * 换种思维，对abb，第一个数a与第二个数b交换得到bab，
     * 然后考虑第一个数与第三个数交换，此时由于第三个数等于第二个数，
     * 所以第一个数就不再用与第三个数交换了。再考虑bab，它的第二个数与第三个数交换可以解决bba。此时全排列生成完毕！
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str != null && str.length() > 0) {

            permutation(str.toCharArray(), 0, list);
            Collections.sort(list); // 按字典序输出
        }
        return list;
    }

    private void permutation(char[] chars, int i, ArrayList<String> list) {

        // 递归结束条件: 剩最后一个字符调用递归函数
        if (i == chars.length) {
            list.add(String.valueOf(chars));
            return;
        }

        // set用于结果去重
        Set<Character> charSet = new HashSet<>();
        for (int j = i; j < chars.length; j++) {

            if (!charSet.contains(chars[j])) {
                charSet.add(chars[j]);
                swap(chars, i, j);  // 交换
                permutation(chars, i + 1, list);
                swap(chars, i, j);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
