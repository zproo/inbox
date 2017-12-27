package priv.zj.others;

public class Node {
    // 用户一旦生成不能改变
    private final int value;

    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public void setNext() {
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.println(head.getValue());
            System.out.println(" ");
            head = head.getNext();
        }
        System.out.println();
    }


}
