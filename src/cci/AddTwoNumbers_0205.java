package cci;
import tools.ListNode;


public class AddTwoNumbers_0205 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pos_l1 = l1;
        ListNode pos_l2 = l2;
        ListNode pre_posl1 = null;
//        ListNode pre_posl2 =null;
        boolean isL1Head = false;
        int bit = 0;
        while (pos_l1 != null && pos_l2 != null) {

            int temp = pos_l1.val+pos_l2.val+bit;
            pos_l1.val = temp%10;
            pos_l2.val = temp%10;

            bit = temp/10;
            pre_posl1= pos_l1;
//            pre_posl2 = pos_l2;
            pos_l1=pos_l1.next;
            pos_l2=pos_l2.next;
        }
        if (pos_l1 == null && pos_l2 == null && bit ==1) {
            pre_posl1.next = new ListNode(1);
            return l1;
        } else if (pos_l1 == null && pos_l2 != null) {
            isL1Head =false;
        }
        else {
            isL1Head = true;
        }

        ListNode rear = (isL1Head)?pos_l1:pos_l2;
        ListNode pre_rear= null;
        while (rear != null) {
            int temp = rear.val+bit;
            rear.val = temp%10;
            bit = temp/10;
            if (bit == 0) {
                break;
            }
            pre_rear= rear;
            rear =rear.next;
        }
        if (bit == 1) {
            pre_rear.next = new ListNode(1);
        }
        return (isL1Head)?l1:l2;
    }
}
