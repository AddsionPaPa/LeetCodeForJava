import java.awt.*;
import java.util.Stack;

public class LargestRectangleInHistogram_084 {


    public static void main(String[] args){

    }

    public int largestRectangleArea(int[] heights){
        if (heights==null || heights.length==0 ){
            return 0;
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int maxarea=0;
        for (int i=0;i<heights.length;i++){

            while (stack.peek()!=-1 && heights[stack.peek()]>heights[i] ){
                int cur=heights[stack.pop()];
                maxarea=Math.max(maxarea,(i-stack.peek()-1)*cur);
            }

            stack.push(i);

        }
        while (stack.peek()!=-1){
            maxarea=Math.max(maxarea,heights[stack.pop()]*(heights.length-stack.peek()-1));
        }
        return maxarea;
    }

}
