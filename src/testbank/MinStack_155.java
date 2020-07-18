package testbank;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.LinkedList;
import java.util.List;

public class MinStack_155 {
    /**
     * 设置两个栈
     * 一个用于存储当前原始数据
     * 一个用于存储最小值数据
     * 入栈 ： 若入栈值小于等于辅助栈顶元素，双栈同时入栈该值
     *         若入栈值大于辅助栈顶元素，仅原始栈入栈该值
     * 出栈 ： 若原始栈出栈值等于辅助栈栈顶元素，双栈同时出栈
     *         若原始栈出栈值大于辅助栈栈顶元素，仅原始栈出栈
     */
    private LinkedList<Integer> raw_stack = new LinkedList<>();
    private  LinkedList<Integer> sup_stack = new LinkedList<>();

    public void push(int x) {
        raw_stack.add(x);
        if (sup_stack.size() == 0 || x<=sup_stack.getLast()) {
            sup_stack.add(x);
        }
    }

    public int top() {
        return raw_stack.getLast();
    }

    public void pop() {
        int pop_num = raw_stack.getLast();
        raw_stack.removeLast();

        if (pop_num == sup_stack.getLast()){
            sup_stack.removeLast();
        }
    }

    public int getMin() {
        return sup_stack.getLast();
    }
}
