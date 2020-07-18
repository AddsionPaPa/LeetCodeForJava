package testbank;

public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = temp ^ nums[i] ;
        }
        return temp;
    }
}
