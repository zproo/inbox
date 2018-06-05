package nowcoder.jianzhioffer.b.b2_举例让抽象具体化_从上往下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode treeNode = q.remove();

            if (treeNode.left != null) {
                q.add(treeNode.left);
            }
            if (treeNode.right != null) {
                q.add(treeNode.right);
            }

            list.add(treeNode.val);
        }

        return list;
    }
}