import org.omg.CORBA.INTERNAL;

public class ValidateBinarySearchTree_098 {
    public static void main(String[] args) {
        ValidateBinarySearchTree_098 test=new ValidateBinarySearchTree_098();
        TreeNode a1=new TreeNode(2);
        TreeNode a2=new TreeNode(1);
        TreeNode a3=new TreeNode(3);
        a1.left=a2;
        a1.right=a3;
        test.isValidBST(a1);

    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public boolean isValidBST(TreeNode root){
//        int low=Integer.MIN_VALUE;
//        int high=Integer.MAX_VALUE;
        return DFS(root,null,null);
    }
    public boolean DFS(TreeNode root, Integer low, Integer high){
        if (root==null){
            return true;
        }
        if (low!=null && root.val<=low)return false;
        if (high!=null && root.val>=high)return false;
        if ((root.left!=null && root.left.val >=root.val) || (root.right!=null && root.right.val <=root.val)){
            return false;
        }
        return DFS(root.left,low,root.val) && DFS(root.right,root.val,high);
    }
}
