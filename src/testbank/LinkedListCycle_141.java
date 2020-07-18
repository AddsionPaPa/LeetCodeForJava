package testbank;

import tools.ListNode;
public class LinkedListCycle_141 {

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return true;
        }
        ListNode slow, fast;
        slow = head;
        fast = head.next;

        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (fast.next == null) {
                break;
            } else {
                fast = fast.next.next;
            }
        }
        return false;
    }
}
