package testbank;

import sun.reflect.generics.tree.Tree;

public class RecoverBinarySearchTree_099 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public  void recoverTree(TreeNode root){

        TreeNode cur=root;
        TreeNode pre = null,predecessor=null,s1=null,s2=null;

        while (cur!=null){
            if (cur.left==null){
                if (pre!=null && pre.val>cur.val){
                    if (s1==null)s1=pre;
                    s2=cur;
                }
                pre=cur;
                cur=cur.right;
            }
            else {
                predecessor=getPreDecessor(cur);
                if (predecessor.right==null){
                    predecessor.right=cur;
                    cur=cur.left;
                }
                else{
                    pre=predecessor;
                    if (pre.val>cur.val){
                        if (s1==null)s1=pre;
                        s2=cur;
                    }
                    pre=cur;
                    predecessor.right=null;
                    cur=cur.right;
                }
            }
        }
        int tmp=s1.val;
        s1.val=s2.val;
        s2.val=tmp;
    }

    public  TreeNode getPreDecessor(TreeNode root){
        TreeNode pre=root.left;
        while(pre.right!=null && pre.right!=root){
            pre=pre.right;
        }
        return pre;
    }
}
