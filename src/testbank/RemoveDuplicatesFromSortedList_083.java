package testbank;

public class RemoveDuplicatesFromSortedList_083 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }
    public static void main(String[] args){

    }

    public ListNode deleteDuplicates(ListNode head){
        ListNode first=head;
        ListNode rear=first.next;
        if (head==null || head.next==null){
            return head;
        }
        while(first.next!=null){
            rear=first.next;
            while (rear!=null && first.val==rear.val){
                rear=rear.next;
            }
            if (rear==first.next){
                first=first.next;
            }
            else {
                first.next=rear;
            }
        }
        return head;
    }

}
