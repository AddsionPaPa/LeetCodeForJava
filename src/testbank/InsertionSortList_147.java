package testbank;

import tools.ListNode;
public class InsertionSortList_147 {

    public ListNode insertionSortedList(ListNode head) {
        /**
         * 思路
         * 1. 按链表顺序遍历，依次插入新链表；
         * 2. 新链表设置尾结点，若遍历结点大于尾结点，直接后入遍历节点。
         */

        if (head == null || head.next ==null) {

            return head;
        }
        ListNode dummy = new ListNode();
        ListNode tail;
        ListNode pos;
        dummy.next = head;
        tail = head;
        pos = head.next;
        tail.next = null;


        while (pos != null) {
            if (pos.val>= tail.val){
                tail.next = pos;
                tail = pos;
                pos = pos.next;
            }
            else {
                ListNode node = pos;
                ListNode temp = dummy;
                pos = pos.next;

                while (temp != tail){
                    if (temp.next.val >= node.val) {
                        node.next = temp.next;
                        temp.next = node;
                        break;

                    }
                    else {
                        temp = temp.next;
                    }
                }

            }
            tail.next = null;
        }
        return dummy.next;
    }
}
