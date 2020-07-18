package testbank;

public class SymmetricTree_101 {
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

    public boolean isSymmetric(TreeNode root) {
        TreeNode symmetric_tree=swapTreeNode(root);
        return isSameTree(symmetric_tree,root);
    }

    public TreeNode swapTreeNode(TreeNode root) {
        if(root==null)return null;
        TreeNode temp=new TreeNode(root.val);
        temp.left=swapTreeNode(root.right);
        temp.right=swapTreeNode(root.left);
//        swapTreeNode(root.left);
//        swapTreeNode(root.right);
        return temp;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        else if ((p!=null && q==null)||(p==null && q!=null)||p.val!=q.val){
            return false;
        }
        else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}
