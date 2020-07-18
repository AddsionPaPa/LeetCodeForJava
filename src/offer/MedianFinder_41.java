package offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 通过建立一个最大堆和一个最小堆来解决问题
 */
public class MedianFinder_41 {
    Queue<Integer> maxHeap,minHeap;

    public MedianFinder_41() {
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int maxHeap_size = maxHeap.size();
        int minHeap_size = minHeap.size();
        if (maxHeap_size == minHeap_size) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        int maxHeap_size = maxHeap.size();
        int minHeap_size = minHeap.size();
        if (maxHeap_size == 0 && minHeap_size==1) {
            return minHeap.peek();
        }
        if (maxHeap_size == 0 && minHeap_size == 0) {
            return 0;
        }
        return (maxHeap.size()==minHeap.size())?((maxHeap.peek()+minHeap.peek())*1.0/2):(1.0*minHeap.peek());
    }
}
