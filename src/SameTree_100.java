public class SameTree_100 {
    public static void main(String[] args){

    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
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
