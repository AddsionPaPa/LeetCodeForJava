package testbank;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Subsets_078 {
    public  static void main(String[] ards){

    }
    List<List<Integer>> out=new LinkedList<>();
    int n;
    int[] nums;
    public List<List<Integer>> subsets(int[] nums){
        this.n=nums.length;
        this.nums=nums;

        backtrace(0, new LinkedList<>());

        return out;
    }
    public void backtrace(int first,LinkedList<Integer> cur){
        out.add(new LinkedList<>(cur));
        if ( first== n ){
//            out.add(new LinkedList<>(cur));
            return;
        }
        for (int i=first;i<n;i++){
            cur.add(nums[i]);

            backtrace(i+1,cur);

            cur.removeLast();
        }
    }
}
