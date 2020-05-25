public class SumRootToLeafNumbers_129 {
       public class TreeNode {
       int val;
       TreeNode left;
      TreeNode right;
       TreeNode(int x) { val = x; }
   }
    public int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return  0;
        }
        dfs(root,0);
        return  sum;
    }

    public  void dfs(TreeNode root, int temp) {
        if (root.left == null && root.right == null) {
            sum+=temp+root.val;
            return ;
        }
        if (root.left != null) {
            dfs(root.left,(temp+root.val)*10);
        }
        if (root.right != null) {
            dfs(root.right,(temp+root.val)*10);
        }

    }
}
