package testbank;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
    /**
     * 1. 回溯算法
     * 2. 通过 S串的起始位置 和 Temp集合 的回溯
     *    将符合条件的集合添加至全局变量res中
     */
    public List<List<String>> res= new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return res;
        }
        DFS(s,0,new ArrayList<>());
        return res;
    }

    public void DFS(String s, int begin, ArrayList<String> temp) {
        if (begin == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = begin + 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(begin, i))) {
                temp.add(new String(s.substring(begin,i)));
                DFS(s,i,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    // 判断是否为回文串
    public boolean isPalindrome(String s) {
        if (s.length() == 1 || s.length() ==0) {
            return true;
        }
        int end = s.length()-1;
        int begin = 0;
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            } else {
                begin++;
                end--;
            }
        }
        return true;

    }
}
