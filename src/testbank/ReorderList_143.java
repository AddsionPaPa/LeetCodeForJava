package testbank;

import  tools.*;
public class ReorderList_143 {
    /**
     * 1. 将该链表以中心为点，分为两段
     * 2. 将第二段链表倒序
     * 3. 两段链表交互链接
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode slow,fast;
        slow = head;
        fast = head.next;

        while (fast.next != null) {
            if (fast.next != null && fast.next.next == null) {
                slow = slow.next;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode left = head;
        ListNode right = slow.next;
        slow.next =null;
        ListNode temp = right;
        ListNode head_insert = new ListNode();
        head_insert.next = null;
        while (right != null) {
            right = right.next;
            temp.next = head_insert.next;
            head_insert.next = temp;
            temp = right;
        }
        right = head_insert.next;
        head_insert.next = null;
        ListNode new_rear = head_insert;

        while (left != null && right != null) {
            new_rear.next = left;
            left = left.next;
            new_rear = new_rear.next;
            new_rear.next = right;
            right = right.next;
            new_rear=new_rear.next;

        }
        new_rear.next = (left!= null)?left:right;

        return;
    }

    public static void main(String[] args) {
        ListNode a4 = new ListNode(4);
        ListNode a3 = new ListNode(3,a4);
        ListNode a2 = new ListNode(2,a3);
        ListNode a1 = new ListNode(1,a2);

        ReorderList_143 test =new ReorderList_143();
        test.reorderList(a1);
    }
}
