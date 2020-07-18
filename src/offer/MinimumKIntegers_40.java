package offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumKIntegers_40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        int length = arr.length;
        if (length == k) {
            return arr;
        }
        if (k == 0) {
            return null;
        }
        int[] res = new int[k];
        Queue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < k; i++) {
            maxHeap.offer(arr[i]);

        }
        for (int i = k; i < length; i++) {
            if (arr[i]>=maxHeap.peek()){
                continue;
            }
            else {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        int i=0;
        for (Integer integer : maxHeap) {
            res[i++] = integer;
        }
        return res;

    }
}
