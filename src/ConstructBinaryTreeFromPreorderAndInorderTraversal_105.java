public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder,int[] inorder) {
        if (preorder.length==0)return null;
        TreeNode root = new TreeNode(preorder[0]);
        int mid=getIndex(inorder,preorder[0]);

        int[] new_left_preoder = new int[mid];
        int[] new_left_inorder = new int[mid];
        int[] new_right_preoder = new int[preorder.length-mid-1];
        int[] new_right_inorder = new int[preorder.length-mid-1];

        System.arraycopy(preorder,1,new_left_preoder,0,mid);
        System.arraycopy(inorder,0,new_left_inorder,0,mid);
        System.arraycopy(preorder,mid+1,new_right_preoder,0,preorder.length-mid-1);
        System.arraycopy(inorder,mid+1,new_right_inorder,0,preorder.length-mid-1);
        root.left=buildTree(new_left_preoder,new_left_inorder );
        root.right=buildTree(new_right_preoder,new_right_inorder);

        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal_105 test=new ConstructBinaryTreeFromPreorderAndInorderTraversal_105();
        int[] a={3,9,20,15,7};
        int[] b={9,3,15,20,7};
        test.buildTree(a,b);
    }

    public int getIndex(int[] array,int x) {
        for (int i=0;i<array.length;i++){
            if (array[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
