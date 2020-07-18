package testbank;

import java.util.*;

public class WordBreak_139 {

    //    public boolean flag ;
//    public boolean wordBreak(String s, List<String> wordDict) {
//        /**
//         *
//         *  设置全局变量，递归查询
//         */
//        Set<String> word = new HashSet<>(wordDict);
//
//        DFS(s,word);
//        return flag;
//    }
//
//    public void DFS(String string,Set<String> wordDict) {
//        if (string.equals("")) {
//            flag = true;
//        }
//        for (int i = 1; i <= string.length(); i++) {
//            if (false == true) {
//                break;
//            }
//
//            if (wordDict.contains(string.substring(0, i))) {
//                DFS(string.substring(i),wordDict);
//            }
//
//        }
//    }
//
//    public static void main(String[] args) {
//        testbank.WordBreak_139 test = new testbank.WordBreak_139();
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("Leet");
//        wordDict.add("Code");
//        test.wordBreak("LeetCode",wordDict);
//        String s= "code";
//        System.out.println("s"+s.substring(1,3)+"s");
//    }
    public boolean wordBreak(String s, List<String> wordDict) {
        /**
         * 1. 转换为集合
         * 2.dp[i]：true or false 表示到i下标的子串
         *   是否可以被wordDict组成
         * 3. Time : O(n^2)
         */
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        Arrays.fill(dp,false);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]&&wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
