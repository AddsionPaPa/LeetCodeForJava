import java.util.Stack;

public class BestTimeToBuyAndSellStockII_122 {
    public int maxProfit(int[] prices) {
        int bottom = 0 ;
        int length= prices.length;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (stack.empty()) {
                bottom = prices[i];
                stack.push(prices[i]);
            } else {
                if (prices[i] >= stack.peek()) {
                    stack.push(prices[i]);
                } else {
                    sum+=stack.peek()-bottom;
                    stack.clear();
                    bottom = prices[i];
                    stack.push(prices[i]);
                }
            }
        }
        if (!stack.empty()) {
            sum+=stack.peek()-bottom;
        }
        return  sum;
    }
}
