package testbank;
import tools.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator_173 {
    public Stack<TreeNode> stack = new Stack<>();
    public BinarySearchTreeIterator_173(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        if (!stack.empty()) {
            TreeNode cur =stack.pop();
            if (cur.right != null) {
//                stack.push(cur.right);
                TreeNode temp = cur.right;
//                cur = cur.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
            return cur.val;
        }
        return -1;
    }

    public boolean hasNext() {
        if (stack.empty()) {
            return  false;
        }
        else {
            return true;
        }
    }
}
