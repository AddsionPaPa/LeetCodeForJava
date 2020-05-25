public class SortColors_075 {
    public  static void main(String[] args){
        int[] arr={2,0,2,1,1,0};
        sortColors(arr);
        for (int i:arr
             ) {
            System.out.print(i+" ");
        }
    }
    public static void sortColors(int[] nums){
        int size=nums.length;
        if (size==0 || size==1){
            return;
        }
        int p0=0;
        int p1=size-1;
        int current=0;

        while (current<=p1){
            int temp;
            if (nums[current]==1){
                current++;
            }
            else if (nums[current]==0){
                nums[current]=nums[p0];
                nums[p0]=0;
                p0++;
                current++ ;
            }
            else {
                nums[current]=nums[p1];
                nums[p1]=2;
                p1--;
//                current++;
            }
        }

    }
}
