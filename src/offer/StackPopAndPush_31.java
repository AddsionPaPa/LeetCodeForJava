package offer;

import com.sun.imageio.plugins.common.I18N;
import org.junit.Test;

import java.util.Stack;

public class StackPopAndPush_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) {
            return  true;
        }
        if (pushed.length != popped.length) {
            return false;
        }
        int push_pos = 0;
        int popped_pos = 0;
        int length = pushed.length;
        Stack<Integer> stack = new Stack<>();

        while (push_pos < length) {
            while (stack.empty()||stack.peek()!=popped[popped_pos]){
                if (push_pos<length){
                    stack.push(pushed[push_pos++]);
                }
                else {
                    break;
                }
            }
            while (!stack.empty()&&stack.peek() == popped[popped_pos]) {
                stack.pop();
                popped_pos++;
            }
        }
        return stack.empty();
    }
        @Test
    public void fun() {
        int[] a = new int[]{8,9,2,3,7,0,5,4,6,1};
        int[] b =new int[]{6,8,2,1,3,9,0,7,4,5};
        validateStackSequences(a,b  );
    }
}
