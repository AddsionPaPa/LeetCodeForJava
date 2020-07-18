package testbank;

public class SingleNumberII_137 {

    public int singleNumber(int[] nums) {
        int a=0,b=0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = b;
            b = (nums[i]^b) & ~a;
            a = (~nums[i]&a&~b)|(nums[i]&~a&temp);
        }
        return b;
    }
}
