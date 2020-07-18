package tools;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public  int val;
    public List<Integer> next;
    public Node left;
    public Node right;

    public Node() {

    }
    public Node(int x) {
        this.val = x;
        this.next = new ArrayList<>();
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
    public void  setNext(List<Integer> next) {
        this.next = next;
    }
}
