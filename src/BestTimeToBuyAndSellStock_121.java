import com.sun.org.apache.bcel.internal.generic.LineNumberGen;

import java.util.Stack;

public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        /**
         * 1.设置单调栈
         * 2.价格比栈顶元素大，入栈
         * 3，价格比栈顶元素小，循环出战，每次出栈与栈底元素比较获取差值。
         */
        Stack<Integer> stack = new Stack<>();
        int bottom=0;
        int maxsize=0;
        int length=prices.length;
        if (length == 0 || length == 1) {
            return maxsize;
        }

        for (int i = 0; i < length; i++) {
            if (stack.empty()) {
                bottom=prices[i];
                stack.push(prices[i]);
            }
            else {
                if (prices[i] >= stack.peek()) {
                    stack.push(prices[i]);
                }
                else {
                    while (!stack.empty()&& prices[i] < stack.peek()) {


                        maxsize=Math.max(maxsize,stack.peek()-bottom);
                        stack.pop();


                    }
                    if (stack.empty()) {
                        bottom = prices[i];
                        stack.push(prices[i]);
                    } else {
                        stack.push(prices[i]);
                    }
                }
            }
        }
        while (!stack.empty()) {
            maxsize=Math.max(maxsize,stack.peek()-bottom);
            stack.pop();
        }
        return maxsize;
    }
}
