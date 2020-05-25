import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversaII_107 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversaII_107 test= new BinaryTreeLevelOrderTraversaII_107();
        TreeNode a1=new TreeNode(3);
        TreeNode a2=new TreeNode(9);
        TreeNode a3=new TreeNode(20);
        TreeNode a4=new TreeNode(15);
        TreeNode a5=new TreeNode(7);
        a1.left=a2;
        a1.right=a3;
        a3.left=a4;
        a3.right=a5;

        test.levelOrderBottom(a1);

    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res=new LinkedList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root == null)return res;
        int count = 1;
        queue.offer(root);

        while (!queue.isEmpty()){

            List<Integer> tmp= new LinkedList<>();
            int new_count=0;
            int i = 1;
            while (i<=count){
                TreeNode cur = queue.poll();


                tmp.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                    new_count++;
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                    new_count++;
                }
                i++;
            }
            count=new_count;
            res.addFirst(tmp);

        }
        return res;
    }
}
