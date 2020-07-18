package testbank;

import jdk.nashorn.internal.objects.NativeUint8Array;
import sun.net.idn.StringPrep;

import java.util.Arrays;

public class MaxinumGap_164 {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n == 1 || n == 0) {
            return 0;
        }
        int[] max_bucket = new  int[n+2];
        int[] min_bucket = new  int[n+2];
        boolean[] flag = new boolean[n+2];
        Arrays.fill(max_bucket,Integer.MIN_VALUE);
        Arrays.fill(min_bucket,Integer.MAX_VALUE);
        Arrays.fill(flag,false);
        int nums_max = Integer.MIN_VALUE;
        int nums_min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            nums_max = Math.max(nums_max,nums[i]);
            nums_min = Math.min(nums_min,nums[i]);
        }
        int bucket_length = Math.max(1,(int)Math.ceil(1.0*(nums_max-nums_min)/(n+1)));

        for (int i = 0; i < n; i++) {
            int temp = (nums[i] - nums_min)/bucket_length;
            max_bucket[temp] = Math.max(nums[i],max_bucket[temp]);
            min_bucket[temp] = Math.min(nums[i],min_bucket[temp]);
            flag[temp] = true;
        }

        int max_gap=0;
        int pos = 0;
        while (pos < n+1 ) {
            int rear = pos+1;
            while (rear<n+2 && flag[rear] == false){
                rear++;
            }
            if (rear < n + 2) {
                max_gap = Math.max(max_gap,min_bucket[rear]- max_bucket[pos]);
            }
            pos= rear;
        }

        return max_gap;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,6,9};
        MaxinumGap_164 test = new MaxinumGap_164();

        System.out.println(test.maximumGap(a));
    }
}
