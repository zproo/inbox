package nowcoder.jianzhioffer.b.b14_时间空间效率的平衡_第一个只出现一次的字符位置;

import java.util.LinkedHashMap;

/*
* 在一个字符串(1<=字符串长度<=10000，全部由字母组成)
* 中找到第一个只出现一次的字符,
* 并返回它的位置
* */
public class Solution {
    // =============方法1：=============
    // 使用一个数组来充当map容器，存取下表使用字符ascii码表示
    public int FirstNotRepeatingChar0(String str) {
        if (str.length() == 0) {
            return -1;
        }

        // 字符是一个长度为8的数据类型，二进制0、1有256中表示
        int[] counts = new int[256];
        for (int i = 0; i < str.length(); i++) {
            // 使用字符的十进制值作为数组下标
            counts[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {

            if (counts[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }




    // =============方法2：=============
    // 思路：使用linkedhashmap，因为一般的hashmap中数据的访问顺序是不确定的
    // 所以一般的hashmap不能 确定 第一个
    public int FirstNotRepeatingChar(String str) {

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                int time = map.get(c);
                map.put(c, ++time);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
