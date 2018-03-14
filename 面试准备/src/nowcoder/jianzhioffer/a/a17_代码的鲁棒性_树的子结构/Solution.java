package nowcoder.jianzhioffer.a.a17_代码的鲁棒性_树的子结构;

/*
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * */
public class Solution {

    /*
     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    /*
     * 树的操作通常使用递归的方式完成
     * 1. 找到值相同的节点R
     * 2. 比较A中以R位根结点的子树中是否包含树B
     * */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {   // 找到相同的节点
                result = DoesTree1HaveTree2(root1, root2);
            }

            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    // 树1 之中是否含有 树2
    boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {

        if (root2 == null) {    // 树2已经比较完了
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return DoesTree1HaveTree2(root1.left, root2.left)
                && DoesTree1HaveTree2(root1.right, root2.right);
    }
}
