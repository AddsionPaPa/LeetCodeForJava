import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelTraversal_102 {
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
        while (!queue.isEmpty()) {
            int i = 1;
            int new_count = 0;
            List<Integer> sub_set=new LinkedList<>();
            while(i<=count){
                TreeNode tmp = queue.poll();
                sub_set.add(new Integer(tmp.val));
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
            res.add(sub_set);
            count=new_count;
        }
        return res;
    }
}
