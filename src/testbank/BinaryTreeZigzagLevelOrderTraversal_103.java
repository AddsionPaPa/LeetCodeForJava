package testbank;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 队列
        List<List<Integer>> res=new LinkedList<>();
        if (root == null) return  res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        boolean flag=true;
        while (!queue.isEmpty()) {
            int i = 1;
            int new_count = 0;
            LinkedList<Integer> sub_set=new LinkedList<Integer>();
            while(i<=count){
                TreeNode tmp = queue.poll();
                if (flag){
                    sub_set.addLast(new Integer(tmp.val));
                }
                else {
                    sub_set.addFirst(new Integer(tmp.val));
                }
                if (tmp.left!=null){
                    queue.offer(tmp.left);
                    new_count++;
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                    new_count++;
                }
                i++;
            }
            flag=!flag;
            res.add(sub_set);
            count=new_count;
        }
        return res;
    }
}
