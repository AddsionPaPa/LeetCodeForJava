package testbank;

public class PopulatingNextRightPointersInEachNode_116 {
    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node next_head = root;
//        Node pre_head = root;
        Node left_pointer;
        while (next_head.left != null) {
            left_pointer = next_head;
            while (left_pointer  != null) {
                left_pointer.left.next=left_pointer.right;
                if (left_pointer.next != null) {
                    left_pointer.right.next = left_pointer.next.left;
                }
                left_pointer=left_pointer.next;
            }
            next_head=next_head.left;

        }
        return root;
    }
}
