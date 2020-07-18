package testbank;

import org.w3c.dom.ls.LSInput;

import java.util.List;

public class RotateList_061 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode rotateRight(ListNode head,int k){
        int length=0;
        int temppos=1;
        ListNode rear=head;
        // ensure length of listnode
        if (head==null){
            return null;
        }
        while (rear != null){
            length++;

            if(rear.next==null){
                rear.next=head;
                break;
            }
            rear=rear.next;
        }
        rear=head;
        while (temppos<(length-k%length)){
            rear=rear.next;
            temppos++;
        }
        head=rear.next;
        rear.next=null;
        return head;
    }
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        ListNode a=new ListNode(2);
        ListNode b=new ListNode(3);
        ListNode c= new ListNode(4);
        ListNode d = new ListNode(5);
        head.next=a;
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=null;
        ListNode temp=rotateRight(head,2);
        while (temp!=null){
            System.out.print(temp.val);
            temp=temp.next;
        }

    }
}
