package nowcoder.jianzhioffer.a.a16_代码的鲁棒性_合并两个排序的链表;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
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
    * 返回链表的头节点
    * */
    public ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode pMergedHead = null;

        if (list1.val < list2.val) {
            pMergedHead = list1;
            pMergedHead.next = Merge(list1.next, list2);
        } else {
            pMergedHead = list2;
            pMergedHead.next = Merge(list1, list2.next);
        }

        return pMergedHead;
    }
}
















