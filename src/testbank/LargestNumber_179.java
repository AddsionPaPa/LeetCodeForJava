package testbank;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber_179 {
    public class Order implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String a = o1+o2;
            String b = o2+o1;
            return b.compareTo(a);
        }
    }

    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }
        String[] nums_string = new String[nums.length];
        String res ="";
        for (int i = 0; i < nums.length; i++) {
            nums_string[i] = String.valueOf(nums[i]);

        }
        Arrays.sort(nums_string,new Order());
        if (nums_string[0].equals("0")){
            return "0";
        }
        for (String str:nums_string){
            res+=str;
        }
        return res;
    }

    public static void main(String[] args) {
        LargestNumber_179 test = new LargestNumber_179();
        test.largestNumber(new int[]{10,2});

    }
}

