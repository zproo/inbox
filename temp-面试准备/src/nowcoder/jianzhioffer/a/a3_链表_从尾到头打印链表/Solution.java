package nowcoder.jianzhioffer.a.a3_链表_从尾到头打印链表;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 即 链表反转
 * */
public class Solution {

    /**
     * 链表数据结构表示
     * public class ListNode {
     * int val;
     * ListNode next = null;
     * <p>
     * ListNode(int val) {
     * this.val = val;
     * }
     * }
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 思路：借助一个栈（先进后出）实现链表的反转，然后存入一个arraylist中
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Stack<Integer> s = new Stack<Integer>();
        while (listNode != null) {
            s.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (!s.isEmpty()) {
            arrayList.add(s.pop());
        }

        return arrayList;
    }

}
