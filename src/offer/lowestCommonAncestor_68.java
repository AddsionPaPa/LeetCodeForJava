package offer;
import org.junit.Test;
import tools.TreeNode;
public class lowestCommonAncestor_68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int left = find(root.left,p,q);
        int righ  = find(root.right,p,q);

        if (left+righ ==2 && left!=2&&righ!=2 || (left+righ ==1 &&(root==p||root==q))){
            return root;
        }
        if (left ==2) {
            return lowestCommonAncestor(root.left,p,q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }

    public int find(TreeNode root, TreeNode p, TreeNode q)  {

        if (root == null) {
            return 0;
        }
        if (root == q || root == p) {
            return find(root.left,p,q)+find(root.right, p, q)+1;
        }
        return find(root.left,p,q )+find(root.right, p, q );

    }

    @Test
    public void fun() {
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(6);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(4);
        TreeNode a6 = new TreeNode(1);
        a1.left=a2;
        a1.right=a3;
        a2.left =  a4;
        a2.right = a5;
        a4.left = a6;
        lowestCommonAncestor(a1,a5,a6);
    }
}
