package offer;
//import tools.MaxComparator;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlideWindowMaximumNumber_59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int res_length = nums.length-k+1;
        int[] res = new int[res_length];
        Queue<Integer> priorityqueue = new PriorityQueue<>(k,new MaxComparator());
        for (int i = 0; i <k ; i++) {
            priorityqueue.offer(nums[i]);
        }
        for (int i = 0; i < res_length; i++) {
            res[i] = priorityqueue.peek();
            priorityqueue.remove(nums[i]);
            if (i+k<nums.length){
                priorityqueue.offer(nums[i+k]);
            }

        }
        return res;
    }
    public class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }

    @Test
    public void fun() {
        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}
