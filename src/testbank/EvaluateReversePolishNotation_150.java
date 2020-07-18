package testbank;

import java.util.*;

public class EvaluateReversePolishNotation_150 {

    public int evalRPN(String[] tokens) {
        List<String> list= new ArrayList<>();
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (list.contains(tokens[i])){
                int index = list.indexOf(tokens[i]);
                int temp;
                if (index == 0) {
                    temp = stack.pop()+stack.pop();
                    stack.push(temp);
                }
                else if (index == 1){
                    temp = stack.pop()-stack.pop();
                    stack.push(temp);
                }
                else if (index == 2){
                    temp = stack.pop()*stack.pop();
                    stack.push(temp);
                }
                else {
                    temp = stack.pop()/stack.pop();
                    stack.push(temp);
                }
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
