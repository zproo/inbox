package nowcoder.jianzhioffer.b.b16_时间空间效率的平衡_两个链表的第一个公共节点;

/*
 *输入两个链表，找出它们的第一个公共结点。
 * */
public class Solution {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead1 == null) {
            return null;
        }

        // 得到两个链表的长度
        int count1 = getListLength(pHead1);
        int count2 = getListLength(pHead2);

        int lengthDiff = count1 - count2;
        if (lengthDiff > 0) {   // 链表1长，先在链表一上走几步
            while (lengthDiff > 0) {
                pHead1 = pHead1.next;
                lengthDiff--;
            }
            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        }
        if (lengthDiff <= 0) {   // 链表1长，先在链表一上走几步
            while (lengthDiff < 0) {
                pHead2 = pHead2.next;
                lengthDiff++;
            }
            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        }
        return null;
    }

    // 得到链表的长度
    public int getListLength(ListNode pHead) {
        int count = 0;
        while (pHead != null) {
            pHead = pHead.next;
            count++;
        }
        return count;
    }
}
