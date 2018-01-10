package bobo.algo.binary_search_tree_05.binary_search_tree_insert_03.temp;

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

    public BST() {
        this.root = null;
        this.count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /*=================================二分搜索树的辅助函数=================================*/

    // 插入一对 key，value
    public void insert(Key key, Value value) {
        insert(root, key, value);
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (node.key.compareTo(key) == 0) {
            node.value = value;
        } else if (node.key.compareTo(key) < 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }

        return node;
    }
}
