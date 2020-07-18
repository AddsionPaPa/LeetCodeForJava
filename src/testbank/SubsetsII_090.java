package testbank;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII_090 {
    List<List<Integer>> res= new LinkedList<>();
    int length;
    int[] nums;
    public  static void main(String[] args){

    }
    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        this.nums=nums;
        this.length=nums.length;

        getSubsets(0,new LinkedList<Integer>());

        return res;

    }
    public void getSubsets(int first,LinkedList<Integer> temp){
//        if (first==length) {
//            return;
//        }

        res.add(new LinkedList<>(temp));

        for (int i=first;i<length;i++){
            temp.add(nums[i]);

            if ((i==first)||(i!=first && nums[i]!=nums[i-1])){
                getSubsets(i+1,temp);
            }

            temp.removeLast();
        }
    }
}
