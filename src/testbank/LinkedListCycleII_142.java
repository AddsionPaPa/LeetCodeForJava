package testbank;

import tools.*;
public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        boolean isCycle = false;
        ListNode slow,fast;
        slow = head;
        if (slow.next == null) {
            return null;
        }
        fast = slow.next;

        while (fast != null) {
            if (slow == fast) {
                isCycle = true;
                break;
            }
            if (fast.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        if (isCycle) {
            slow = new ListNode(0);
            slow.next = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;

    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a2;
        LinkedListCycleII_142 test =new LinkedListCycleII_142();
        test.detectCycle(a1);
    }
}
