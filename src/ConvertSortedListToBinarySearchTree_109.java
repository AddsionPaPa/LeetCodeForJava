public class ConvertSortedListToBinarySearchTree_109 {
    public static void main(String[] args) {
       ConvertSortedListToBinarySearchTree_109 test=  new ConvertSortedListToBinarySearchTree_109();
        ListNode a1= new ListNode(-10);
        ListNode a2= new ListNode(-3);
        ListNode a3= new ListNode(0);
        ListNode a4= new ListNode(5);
        ListNode a5= new ListNode(9);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        test.sortedListToBST(a1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode new_head = new ListNode(0);
        new_head.next=head;
        ListNode slow=new_head.next;
        ListNode fast=slow.next;
        ListNode rear=new_head;

        while (fast != null && fast.next != null) {
            rear=rear.next;
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if (rear == new_head) {
            root.left=null;
        }
        else {
            rear.next=null;
            root.left = sortedListToBST(new_head.next);
        }
        if (slow.next == null) {
            root.right = null;
        }
        else {
            root.right = sortedListToBST(slow.next);
        }

        return root;
    }
}
