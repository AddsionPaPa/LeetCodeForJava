package offer;
import tools.Node;
public class BinaryTreeAndList_36 {
    public Node pre;
    public Node head;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return  null;
        }
        dfs(root);
        pre.right = head;
        head.left = pre;

        return head;
    }
    public void dfs(Node cur){
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        }
        else {
            head = cur;
        }
        cur.left = pre;
        pre =cur;
        dfs(cur.right);
    }
}
