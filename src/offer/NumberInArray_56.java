package offer;

import org.junit.Test;

public class NumberInArray_56 {

    public int[] singleNumbers(int[] nums) {
        int temp = 0;
        int a = 0;
        int b = 0;
        int bit=1;
        for (int i = 0; i < nums.length; i++) {
            temp^=nums[i];
        }
        for (int i = 0; i <32 ; i++) {
            if ((temp & bit) == 0) {
                bit<<=1;
            }
            else {
                break;
            }
        }
        for (int i = 0; i <nums.length ; i++) {
            if ((nums[i] & bit) ==0) {
                a ^= nums[i];
            } else {
                b^=nums[i];
            }
        }
        return new int[]{a,b};
    }

    @Test
    public void fun() {
        singleNumbers(new int[]{1,2,5,2});
    }
}
