package testbank;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII_229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> integerList = new ArrayList<>();
        int majority_A = nums[0];
        int majority_B = nums[0];
        int count_A = 0;
        int count_B = 0;
        if(nums.length==0){
            return integerList;
        }
        for (int i=0; i < nums.length; i++) {

            if (nums[i] == majority_A) {
                count_A++;
                continue;
            }
            if (nums[i] == majority_B) {
                count_B ++;
                continue;
            }

            if (count_A == 0) {
                majority_A = nums[i];
                count_A++;
                continue;

            }
            if (count_B == 0) {
                majority_B = nums[i];
                count_B++;
                continue;
            }
            count_A--;
            count_B--;

        }
        count_A=0;
        count_B =0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majority_A) {
                count_A++;
                if (count_A > (nums.length / 3)&& !integerList.contains(majority_A)) {
                    integerList.add(majority_A);
                }
            }
            if (nums[i] == majority_B) {
                count_B++;
                if (count_B > (nums.length / 3)&& !integerList.contains(majority_B)) {
                    integerList.add(majority_B);
                }
            }
        }
        return  integerList;
    }
}
