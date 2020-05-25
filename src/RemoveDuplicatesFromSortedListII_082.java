public class RemoveDuplicatesFromSortedListII_082 {
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
        ListNode start=new ListNode(Integer.MIN_VALUE);
        start.next=head;
        ListNode first=start;
        ListNode rear;
        if (head==null || head.next==null){
            return head;
        }
        while (first.next!= null){
            if(first.val != first.next.val){
                rear=first.next;
                while(rear.next!=null && rear.val==rear.next.val){
                    rear=rear.next;
                }
                if (rear == first.next){
                    first=first.next;
                }
                else {
                    first.next=rear.next;
                }
            }
        }
        return start.next;
    }
}
