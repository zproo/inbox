package bobo.algo.binary_search_tree_05.binary_search_tree_basic_02.temp;

public class BST<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node root; //  根节点
    private int count; // 树种节点的个数

    public BST(Node root, int count) {
        this.root = null;
        this.count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
