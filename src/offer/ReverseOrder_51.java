package offer;

public class ReverseOrder_51 {
//    public  int count =0;
    // 利用二分法实现
    public int reversePairs(int[] nums) {
        int length = nums.length;
        int[] num = new int[length];
        for (int i = 0; i <length ; i++) {
            num[i]=nums[i];
        }
        int[] temp = new int[length];
        return sort(num,0,length-1,temp);
    }

    public int sort(int[] num, int left,int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left+(right-left)/2;
        int leftNumber = sort(num,left,mid,temp);
        int rightNumber = sort(num,mid+1,right,temp);
        return leftNumber+rightNumber+merge(num,left,mid,right,temp);
    }

    public int merge(int[] num, int left, int mid, int right, int[] temp) {
        for (int i = left; i <=right ; i++) {
            temp[i] = num[i];
        }
        int count=0;
        int pos =left;
        int right_pos = mid+1;
        int left_pos= left;
        for (int i = left; i <=right ; i++) {
            if (left_pos == mid + 1) {
                num[i] = temp[right_pos];
                right_pos++;
            } else if (right_pos == right + 1) {
                num[i] = temp[left_pos];
                left_pos++;
            } else if (temp[left_pos] <= temp[right_pos]) {
                num[i] = temp[left_pos];
                left_pos++;
            }
            else {
                num[i] = temp[right_pos];
                right_pos++;
                count+=mid+1-left_pos;
            }
        }
        return count;
    }
}
