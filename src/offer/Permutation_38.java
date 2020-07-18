package offer;

import org.junit.Test;

import java.util.*;

public class Permutation_38 {
    public char[] chars;
    public int chars_length;
    public List<String> res;
   public String[] permutation(String s) {
        // 初始化字符数组
        chars = s.toCharArray();
        Arrays.sort(chars);
        chars_length = chars.length;
        if (chars_length == 0) {
            return null;
        }
        res= new LinkedList<>();
        boolean[] visited = new boolean[chars_length];
        Arrays.fill(visited,false);
        backtracking(visited,new LinkedList<>(),0);
        return res.toArray(new String[chars_length]);
    }
    public void backtracking(boolean[] visited, LinkedList<Character> cur,int count){
        if (count==chars_length){
            StringBuilder stringBuilder = new StringBuilder();
            for (Character c:cur) {
                stringBuilder.append(c);
            }
            res.add(stringBuilder.toString());
        }
        char c = '.';
        for (int i = 0; i < chars_length; i++) {
            if (!visited[i] && ( chars[i]!=c)){
                c = chars[i];
                visited[i]= true;
                cur.add(chars[i]);
                backtracking(visited,cur,count+1);
                cur.removeLast();
                visited[i]= false;
            }
        }
    }
//
    @Test
    public void fun() {
        permutation("aab");
        Queue<Integer> queue = new PriorityQueue<>();
    }
}
