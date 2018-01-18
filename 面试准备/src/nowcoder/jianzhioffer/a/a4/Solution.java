package nowcoder.jianzhioffer.a.a4;

/*
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * */
public class Solution {
    /**
     * Definition for binary tree
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    * 要求：返回重建的二叉树的根
    * 思路：二叉树一般使用递归进行操作
    * 前序-根左右    中序-左根右
    *
    * */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        // 递归结束条件
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        // 前序的第一个元素即根节点
        TreeNode root = new TreeNode(pre[startPre]);

        // 遍历中序，找到根节点位置，左、右元素分别为左子树和右子树
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + (i - startIn), in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + (i-startIn) + 1, endPre, in, i + 1, endIn);
            }
        }

        return root;
    }
}
















