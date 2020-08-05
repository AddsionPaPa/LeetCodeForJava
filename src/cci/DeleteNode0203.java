package cci;
import tools.ListNode;
public class DeleteNode0203 {


    public void deleteNode(ListNode node) {
        ListNode head = node;
        ListNode rear = head.next;
        head.val= rear.val;
        while (rear.next != null) {
            head.val = rear.val;
            head = head.next;
            rear = rear.next;
        }
        head.val = rear.val;
        head.next=null;
    }
}
