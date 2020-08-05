package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumInQueue_59 {

    public Queue<Integer> queue  ;
    public LinkedList<Integer> deque  ;

    public MaximumInQueue_59() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return (deque.isEmpty())?-1:deque.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.getLast() < value) {
            deque.removeLast();
        }
        deque.offer(value);
    }

    public int pop_front() {
        if (!deque.isEmpty() && queue.peek().equals(deque.peek())) {
            deque.removeFirst();
        }
        return queue.size()==0?-1:queue.poll();
    }
}
