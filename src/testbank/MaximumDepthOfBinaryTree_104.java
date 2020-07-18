package testbank;

public class MaximumDepthOfBinaryTree_104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        else return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }
}
