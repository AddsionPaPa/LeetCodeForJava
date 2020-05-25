import org.w3c.dom.html.HTMLIsIndexElement;

import java.util.List;

public class ReverseLinkedListII_092 {
    public static void main(String[] args){
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        ListNode a5=new ListNode(5);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        reverseBetween(a1,2,5);
        while (a1!=null){
            System.out.println(a1.val);
            a1=a1.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n){
        if (m==n){
            return head;
        }
        int count=n-m;
        ListNode new_head=new ListNode(0);
        new_head.next=head;
        ListNode rear;
        ListNode new_head_rear=new_head;
        ListNode next_head;
        ListNode pos;
        ListNode pos_next;

        for (int i=1;i<m;i++){
            new_head_rear=new_head_rear.next;
        }
        rear=new_head_rear.next;
        next_head=new_head_rear.next;
        pos=next_head.next;
        pos_next=pos.next;
        while(count>0){
            new_head_rear.next=pos;
            pos.next=next_head;
            next_head=pos;

            pos=pos_next;
            if (pos==null){
                pos_next=null;
            }
            else{
                pos_next=pos.next;
            }

            count--;
        }
        rear.next=pos;
        return new_head.next;
    }

}
