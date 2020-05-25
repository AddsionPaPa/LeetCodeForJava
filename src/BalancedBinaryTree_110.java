import sun.reflect.generics.tree.Tree;

public class BalancedBinaryTree_110 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 获取 左右子树的 各自高度
        int left_height=getHeight(root.left);
        int right_height=getHeight(root.right);

        if (Math.abs(left_height-right_height)>1){
            return false;
        }
        else {
            return isBalanced(root.left)&&isBalanced(root.right);
        }
        //比较后返回值

    }

    // get Height of sub_tree

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}
