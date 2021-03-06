package nowcoder.jianzhioffer.a.a2_字符串_替换空格;

/*
* 请实现一个函数，将一个字符串中的空格替换成“%20”。
* 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
* */
public class Solution {
    // 思路: 转换为字符串，逐字符匹配，将空格替换为%20
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        StringBuffer stringBuffer = new StringBuffer("Hello World");

        System.out.println(solution.replaceSpace(stringBuffer));
    }
}
