package nowcoder.jianzhioffer.b.b19_知识迁移能力_平衡二叉树;

/*
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * */
public class Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    // 考察对二叉树的熟悉和输的遍历
    // 树一般使用递归的方式操作
    public int TreeDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return (left > right) ? (left + 1) : (right + 1);
    }

    /*
    平衡二叉树：每个节点 的左右子树的深度相差都不超过1
    */
    public boolean IsBalanced_Solution(TreeNode root) {

        if (root == null) {
            return true;
        }

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int diff = left - right;
        if (diff > 1 || diff < -1) {
            return false;
        }

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
}
