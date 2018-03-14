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

    /*
    * 思路：两个指针，先让第一个指针和第二个指针都指向头结点，
    * 然后再让第一个指正走(k-1)步，到达第k个节点。
    * 然后两个指针同时往后移动，当第一个结点到达末尾的时候，
    * 第二个结点所在位置就是倒数第k个节点了
    * */
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
