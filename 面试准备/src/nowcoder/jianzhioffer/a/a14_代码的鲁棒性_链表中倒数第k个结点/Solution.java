package nowcoder.jianzhioffer.a.a14_代码的鲁棒性_链表中倒数第k个结点;

/*
 * 输入一个链表，输出该链表中倒数第k个结点。
 * */
public class Solution {

    /*public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }*/
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode pFirst = head;
        ListNode pBehind = head;
        
        // pFirst先向前走 k-1 步
        for (int i = 1; i < k; i++) {
            
            if (pFirst.next != null) {
                pFirst = pFirst.next;
            } else { // 链表不足k个元素
                return null;
            } 
        }

        pBehind = head;
        while (pFirst.next != null) {
            pFirst = pFirst.next;
            pBehind = pBehind.next;
        }

        return pBehind;
    }
}
