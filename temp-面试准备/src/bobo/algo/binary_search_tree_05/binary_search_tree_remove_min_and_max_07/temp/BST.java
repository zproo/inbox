package bobo.algo.binary_search_tree_05.binary_search_tree_remove_min_and_max_07.temp;

import java.util.LinkedList;

public class BST<Key extends Comparable<Key>, Value> {
    // Node使用private的
    // 一个好的类的封装需要内部结构对外隐藏
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
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    // 插入一对 key，value
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    public boolean contain(Key key) {
        return contain(root, key);
    }

    // 在二分搜索树中搜索键key所对应的值。如果这个值不存在, 则返回null
    public Value search(Key key) {
        return search(root, key);
    }

    /*
     * 二分搜索树的遍历
     * 前中后序三种方式，属于 深度优先遍历（从一开始尝试走到最深）
     * */
    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void levelOrder() {
        // 使用linkedlist代替队列
        LinkedList<Node> q = new LinkedList<Node>();

        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.remove(); // 移除并返回列表的头（第一个元素）

            System.out.println(node.key);

            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    // 查找最小节点的key
    public Key minimum() {

        assert count != 0;
        Node minNode = minimum(root);
        return minNode.key;
    }

    public Key maximum() {

        assert count != 0;
        Node minNode = maximum(root);
        return minNode.key;
    }

    // 删除最小节点
    public void removeMin() {

        if (root != null) {
            root = removeMin(root);
        }
    }

    public void removeMax() {

        if (root != null) {
            root = removeMax(root);
        }
    }

    /*=================================二分搜索树的辅助函数=================================*/
    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (node.key.compareTo(key) == 0) {
            node.value = value;
        } else if (node.key.compareTo(key) < 0) {
            node.right = insert(node.right, key, value);
        } else {
            node.left = insert(node.left, key, value);
        }

        return node;
    }

    private boolean contain(Node node, Key key) {
        if (node == null) {
            return false;
        }

        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }

    private Value search(Node node, Key key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }

    }

    private void preOrder(Node node) {

        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void inOrder(Node node) {

        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    private void postOrder(Node node) {

        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    private Node minimum(Node node) {

        if (node.left == null) {

            return node;
        }
        return minimum(node.left);
    }

    private Node maximum(Node node) {

        if (node.right == null) {

            return node;
        }
        return maximum(node.right);
    }

    private Node removeMin(Node node) {

        // 找到最小的节点
        if (node.left == null) {
            Node rightNode = node.right;

            // 删除node
            node.right = null;
            count--;

            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node removeMax(Node node) {

        // 找到最小的节点
        if (node.right == null) {
            Node leftNode = node.left;

            // 删除node
            node.left = null;
            count--;

            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public static void main(String[] args) {

        int N = 1000000;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++)
            arr[i] = new Integer(i);

        // 打乱数组顺序
        for (int i = 0; i < N; i++) {
            int pos = (int) (Math.random() * (i + 1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = arr[pos];
        }
        // 由于我们实现的二分搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表
        // 平衡二叉树的实现，我们在这个课程中没有涉及，
        // 有兴趣的同学可以查看资料自学诸如红黑树的实现
        // 以后有机会，我会在别的课程里向大家介绍平衡二叉树的实现的：）


        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BST<Integer, String> bst = new BST<Integer, String>();
        for (int i = 0; i < N; i++)
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for (int i = 0; i < 2 * N; i++) {
            String res = bst.search(new Integer(i));
            if (i < N)
                assert res.equals(Integer.toString(i));
            else
                assert res == null;
        }
    }
}













