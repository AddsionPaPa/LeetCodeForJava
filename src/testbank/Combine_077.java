package testbank;

import java.util.LinkedList;
import java.util.List;

public class Combine_077 {
    public static void main(String[] args){

    }
    List<List<Integer>> out=new LinkedList<>();
    int n;
    int k;
    public void backtrace(int first,LinkedList<Integer> cur){
        if (cur.size()==k){
            out.add(new LinkedList<>(cur));
        }
        for (int i =first;i<n+1;i++){
            // 增加数字
            cur.add(i);
            //递归
            backtrace(i+1,cur);
            // 删除增加的数字
            cur.removeLast();
        }
    }
    public List<List<Integer>> combine(int n, int k){
        this.n=n;
        this.k=k;
        backtrace(1,new LinkedList<Integer>());
        return out;
    }
}
