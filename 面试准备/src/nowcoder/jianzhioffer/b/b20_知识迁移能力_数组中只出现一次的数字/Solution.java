package nowcoder.jianzhioffer.b.b20_知识迁移能力_数组中只出现一次的数字;

/*
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * */
public class Solution {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        if (array == null || array.length < 2) {
            return;
        }
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp ^= array[i];
        }
        int indexBit1 = findFirstIntIs1(temp);
        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], indexBit1)) {  //倒数第indexBit1位是1
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }

    }

    // 找到第一个为1的位置
    public int findFirstIntIs1(int num) {

        int indexBit1 = 0;
        // Java中int类型占4byte，32位
        while (((num & 1) == 0) && (indexBit1) < 4 * 8) {
            num = num >> 1;
            indexBit1++;
        }
        return indexBit1;
    }

    // 数字num的倒数第indexBit1位是否为1
    public boolean isBit1(int num, int indexBit1) {
        num = num >> indexBit1;
        return (num & 1) == 1;
    }
}
