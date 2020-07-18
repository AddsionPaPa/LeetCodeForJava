package offer;

import org.junit.Test;

import java.util.Stack;

public class TwoStackToQueue_09 {
    public Stack<Integer> push_stack;
    public Stack<Integer> pop_stack;

    public TwoStackToQueue_09(){
        push_stack = new Stack<>();
        pop_stack = new Stack<>();
    }

    public void appendTail(int value) {
        push_stack.push(value);

    }

    public int deleteHead() {
        if (pop_stack.empty() && push_stack.empty()) {
            return -1;
        } else {
            if (pop_stack.empty()) {
                while (!push_stack.empty()) {
                    pop_stack.push(push_stack.pop());
                }
            }
            return pop_stack.pop();
        }
    }
    @Test
    public void fun() {
        int i = 1000000007;
        System.out.println(i);
        System.out.println(1e+10);
    }
}
