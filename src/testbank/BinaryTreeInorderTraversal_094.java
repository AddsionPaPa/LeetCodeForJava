package testbank;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_094 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        TreeNode temp=root;
        Stack<TreeNode> stack=new Stack<>();

        // 压栈
        while(temp!=null){
            stack.push(temp);
            temp=temp.left;
        }

        // 出栈
        while (!stack.isEmpty()){
            temp=stack.pop();
            res.add(new Integer(temp.val));

            // 右侧分支入栈
            temp=temp.right;
            while (temp != null) {
                stack.push(temp);
                temp=temp.left;
            }
        }
        return res;

    }
}
