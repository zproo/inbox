package priv.zj.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListCreate {
    public static void main(String[] args) {
        LinkedListCreate creator = new
                LinkedListCreate();
        Node.printLinkedList(creator.createLinkedList(new ArrayList<>()));
        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1)));
        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));
    }


    /*
     * create binary_search_01 linked list
     * @param data the data to create the list
     * @return head of the linked list. The returned linked list
     * ends with last node with getNext() == null
     * */
    public Node createLinkedList(List<Integer> data) {
        if (data.isEmpty()) {
            return null;
        }

        Node firstNode = new Node(data.get(0));
        Node headOfSublist = createLinkedList(data.subList(1, data.size()));
        firstNode.setNext(headOfSublist);
        return firstNode;
    }
}
