public class RemoveDuplicatesII_080 {
    public static void main(String[] args){

    }
    public int removeDuplicates(int[] nums){
        int n=nums.length;
        int head=1;
        int count=1;
        if (n==0 || n==1 || n==2){
            return n;
        }
        for (int rear=1;rear<n;rear++ ){
            if (nums[rear]==nums[rear-1]){
                count++;
            }
            else{
                count=1;
            }
            if (count<=2){
                nums[head++]=nums[rear];
            }
        }
        return head;
//        while (rear<n){
//            if (nums[head]==nums[head-1]){
//                count++;
//            }
//            else {
//                count=1;
//            }
            //错误想法
//            if (nums[head]!=nums[rear]){
//                nums[head]=nums[rear];
//                if (count==3){
//                    rear++;
//                }
//                else {
//                    head++;
//                    rear++;
//                }
//            }
//            if (count==3){
//                if (nums[head]!=nums[rear]){
//                    nums[head]=nums[rear];
//                   head++;
//                }
//                rear++;
//            }
//            else {
//                if (nums[head]==nums[rear]){
//                    rear++;
//                }
//                head++;
//            }

//        }

    }
}
