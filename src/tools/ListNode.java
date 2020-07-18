package tools;

public class ListNode {
    public ListNode next;
    public int val;
    public ListNode() {
    }
    public ListNode(int x) {
        val = x;
        next = null;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
