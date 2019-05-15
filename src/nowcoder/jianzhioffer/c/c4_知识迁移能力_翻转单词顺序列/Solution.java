package nowcoder.jianzhioffer.c.c4_知识迁移能力_翻转单词顺序列;

/*
 * 描述：反转英文单词，例如，“student. a am I”反转成“I am a student.”
 * */
public class Solution {

    public String ReverseSentence(String str) {

        // trim去掉前后的多余空格
        if (str == null || str.trim().equals("")) {
            return str;
        }
        // 反转整个句子
        String reverseStr = reverse(str.toCharArray(), 0, str.length() - 1);

        // 反转每个单词
        StringBuffer stringBuffer = new StringBuffer();
        String[] words = reverseStr.split(" ");    // 以空格分隔出每个单词
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            stringBuffer.append(reverse(word.toCharArray(), 0, word.length() - 1)).append(" ");
        }
        if (stringBuffer.length() > 0) {    // 删除最后一个空格
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    private String reverse(char[] str, int left, int right) {

        if (left > right) {
            return "";
        }

        char temp;
        while (left < right) {
            temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(str);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "I am a student.";
        System.out.println(solution.ReverseSentence(s));
    }
}
