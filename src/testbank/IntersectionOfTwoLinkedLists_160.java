package testbank;
import tools.ListNode;
public class IntersectionOfTwoLinkedLists_160 {
    /**
     * 追击法 来确定相差距离
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a_temp = headA;
        ListNode b_temp = headB;
        int count =0;
        if (a_temp == null || b_temp == null) {
            return null;
        }
        while (b_temp.next!=null&&a_temp.next!=null) {
            a_temp = a_temp.next;
            b_temp = b_temp.next;
        }
        if (a_temp == b_temp) {
            return a_temp;
        }
        if (a_temp.next == null) {
            a_temp = b_temp;
            b_temp = headB;
            ListNode t = headA;
            headA = headB;
            headB = t;
        } else {
            b_temp = headA;
        }
        while (a_temp.next != null) {
            a_temp=a_temp.next;
            b_temp=b_temp.next;
        }
        a_temp = headB;
        while (b_temp != a_temp) {
            a_temp =a_temp.next;
            b_temp = b_temp.next;
        }
        if (a_temp != null) {
            return a_temp;
        }
        return null;
    }
}
