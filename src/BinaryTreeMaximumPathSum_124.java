public class BinaryTreeMaximumPathSum_124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        /**
         * 需要维护一个全局max变量用于记录最大值
         * 三种情况：1.root+root.left + root.ancestor
         *          2.root+root.right + root.ancestor
         *          3.root + root.left + root.right
         */
        if (root == null) {
            return 0;
        }
        int left=Math.max(0,maxPathSum(root.left));
        int right=Math.max(0,maxPathSum(root.right));

        max = Math.max(max,root.val+left+right);

        return root.val+Math.max(left,right);
    }
}
