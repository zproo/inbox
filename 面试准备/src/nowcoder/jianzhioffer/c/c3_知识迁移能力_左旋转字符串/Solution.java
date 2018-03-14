package nowcoder.jianzhioffer.c.c3_知识迁移能力_左旋转字符串;

/*
 * 扩展题：字符串左移n位，abcde，左移2位，cdeab
 * */
public class Solution {

    public String LeftRotateString(String str, int n) {

        char[] chars = str.toCharArray();
        if (chars.length < n) {
            return "";
        }
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        StringBuilder stringBuilder = new StringBuilder(chars.length);
        for (char c : chars) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private void reverse(char[] chars, int left, int right) {

        char temp;
        while (left < right) {
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }


}
