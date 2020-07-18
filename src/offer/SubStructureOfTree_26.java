package offer;

import tools.TreeNode;

public class SubStructureOfTree_26 {
    public boolean flag = false;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        if (A.val == B.val && flag==false) {
            flag = isSub(A,B);
        }
       
            if (A.left!=null && flag == false){
                 flag =isSubStructure(A.left,B);
            }
            if (A.right != null && flag == false) {
                flag = isSubStructure(A.right,B);
            }

        return  flag;
    }

    public boolean isSub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }

        return isSub(A.left,B.left) && isSub(A.right,B.right);

    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(8);
        TreeNode a9 = new TreeNode(9);
        TreeNode b1 = new TreeNode(4);
        TreeNode b2 = new TreeNode(8);
        TreeNode b3 = new TreeNode(9);
        a1.left = a2;
        a1.right=a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;
        a4.left = a8;
        a4.right= a9;
        b1.left = b2;
        b1.right = b3;
        SubStructureOfTree_26 test =new SubStructureOfTree_26();
        test.isSubStructure(a1,b1);
    }
}
