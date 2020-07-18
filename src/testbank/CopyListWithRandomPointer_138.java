package testbank;

public class CopyListWithRandomPointer_138 {
    public static class Node {
        int val ;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer_138 test = new CopyListWithRandomPointer_138();
        Node a1 = new Node(7);
        Node a2 = new Node(13);
        Node a3 = new Node(11);
        Node a4 = new Node(10);
        Node a5 = new Node(1);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        a5.next=null;
        a1.random=null;
        a2.random=a1;
        a3.random=a5;
        a4.random=a3;
        a5.random=a1;
        test.copyRandomList(a1);
    }
    public Node copyRandomList(Node head) {
        /**
         * 1. 复制每个节点 将复制的节点插入其后 形成交叉结点
         *      1 -> 1' -> 2 -> 2' -> null
         * 2. 改变随机结点指向
         * 3. 将复制节点分离出原链表
         */
        if (head == null) {
            return null;
        }
        Node start = head;
        while (start != null) {
            Node new_node = new Node(start.val);
            new_node.next = start.next;
            start.next = new_node;
            start = new_node.next;
        }
        start = head;

        while (start != null) {
            if (start.random != null) {
                start.next.random = start.random.next;
            } else {
                start.next.random = null;
            }
            start = start.next.next;
        }


        Node copy = new Node(-1);
        Node copy_rear =head.next;
        Node original = new Node(-1);
        Node original_rear = head;
        copy.next = copy_rear;
        original.next = original_rear;

        while (copy_rear.next != null) {
            original_rear.next = copy_rear.next;
            original_rear=original_rear.next;
            copy_rear.next=original_rear.next;
            copy_rear=copy_rear.next;
        }
        original_rear.next=null;
        return  copy.next;
    }
}
