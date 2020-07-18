package offer;
import sun.reflect.generics.tree.Tree;
import tools.TreeNode;

import java.util.*;


public class SerializeAndDeserializeBinaryTree_37 {

    public String serialize(TreeNode root) {
        String res = "";
        if (root == null) {
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                res =res+"null,";
            }
            else {
                res = res + String.valueOf(temp.val)+",";
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        int length = res.length();
        res = res.substring(0,length-1);
        return "["+res+"]";
    }

    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        int length = data.length();
        String[] sub_data = data.substring(1,length-1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(sub_data[0]));
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if (sub_data[i].equals("null")) {
                temp.left =null;
            }
            else {
                temp.left = new TreeNode(Integer.parseInt(sub_data[i]));
                queue.offer(temp.left);
            }
            i++;
            if (sub_data[i].equals("null")) {
                temp.right=null;
            }
            else {
                temp.right= new TreeNode(Integer.parseInt(sub_data[i]));
                queue.offer(temp.right);
            }
            i++;
        }
        return root;

    }
}
