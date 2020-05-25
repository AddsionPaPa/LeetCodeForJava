import java.util.List;

public class PartitionList_086 {

    public static  void main(String[] args){
        PartitionList_086 x=new PartitionList_086();
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(4);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(2);
        ListNode a5=new ListNode(5);
        ListNode a6=new ListNode(2);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        a5.next=a6;
        x.partition(a1,3);
//        while (y!=null){
//            System.out.print (y.val + " ");
//            y=y.next;
//        }
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int s){
            val=s;
        }
    }

    public ListNode partition(ListNode head,int x){
        if (head==null || head.next==null ){
            return head;
        }
        ListNode left=new ListNode(0);
        ListNode left_rear=left;
        ListNode right=new ListNode(0);
        ListNode right_rear=right;
        ListNode rear=head;
        while (rear!=null){
            if (rear.val<x){
                left_rear.next=rear;
                left_rear=left_rear.next;
            }
            else {
                right_rear.next=rear;
                right_rear=right_rear.next;
            }
            rear=rear.next;
        }
        left_rear.next=null;
        right_rear.next=null;
//        while (left!=null){
//            System.out.println(left.val);
//            left= left.next;
//        }
//        while (right!=null){
//            System.out.println(right.val);
//            right= right.next;
//        }
        if (left.next==null){
            return  right.next;
        }
        else {
            left_rear.next=right.next;
            return left.next;
        }
//        return  null;
    }
}
