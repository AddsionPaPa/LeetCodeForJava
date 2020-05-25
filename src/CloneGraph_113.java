import java.util.*;

public class CloneGraph_113 {
    public class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        /**
         * 1. 查看该结点是否被访问过
         * 2. 若访问过，从hashMap中得到该结点
         * 3、若没有该节点，生成新结点，加入HashMap
         * 4、遍历node 的 neighbors，递归
         */
        if (node == null) {
            return null;
        }
        Node root;
        if (visited.containsKey(node)) {
            return visited.get(node);
        } else {
            root = new Node(node.val);
            visited.put(node, root);
        }
        for (Node neighbor : node.neighbors) {
            root.neighbors.add(cloneGraph(neighbor));
        }
        return root;

    }
}
