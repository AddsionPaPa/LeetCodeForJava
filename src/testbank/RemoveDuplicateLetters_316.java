package testbank;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveDuplicateLetters_316 {

    /**
     * 删除重复字符
     * 并保证最小字典序
     * 策略：
     * 1. 栈：如果栈空或者该元素字典序大于栈顶元素，
     * 或者 小于栈顶元素且栈顶元素在后续子字符串人存在，则出栈再入栈
     * 2. 如何判断元素个数，利用哈希Map
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();

        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c,1);
            }
            else {
                int count = map.get(c);
                map.put(c,count+1);
            }
        }

        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            int count;

            count = map.get(c);
            map.put(c,count-1);
            if (stack.contains(c)) {
                continue;
            }
            else {
                if (stack.empty()|| c> stack.peek()) {
                    stack.push(c);
                    continue;
                }
                while(!stack.empty()&&c < stack.peek() && map.get(stack.peek()) > 0) {
                    stack.pop();
                }
                stack.push(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character c:stack) {
            stringBuilder.append(c.charValue());
        }



        return stringBuilder.toString();
    }


    @Test
    public void fun() {
         removeDuplicateLetters("bcabc");
    }
}
