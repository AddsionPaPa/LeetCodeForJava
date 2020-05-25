import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII_113 {
       public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
    public List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathDFS(root,sum,new LinkedList<>());
        return res;
    }

    public void pathDFS(TreeNode root, int sum, LinkedList<Integer> cur) {
        if (root == null) {
            return;
        }
        cur.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
//            cur.add(root.val);
            res.add(new LinkedList<>(cur));
//            cur.removeLast();
        }
        if (root.left != null) {
//            cur.add(root.val);
            pathDFS(root.left,sum-root.val,cur);
//            cur.removeLast();
        }
        if (root.right != null) {
            pathDFS(root.right,sum-root.val,cur);
        }
        cur.removeLast();
    }
}
