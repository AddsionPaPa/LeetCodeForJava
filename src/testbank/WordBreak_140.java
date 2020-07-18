package testbank;

import java.util.*;

public class WordBreak_140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        Arrays.fill(dp,false);
        dp[0]= true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (dp[s.length()] ==false){
            return res;
        }
        LinkedList<String> queue = new LinkedList<>();
//        dfs(s,s.length(),wordSet,res,queue,dp);
        backTrack(dp,s,s.length(),queue,wordSet,res);
        return res;
    }

    public void backTrack(boolean[] dp, String s, int end,LinkedList<String> queue,Set<String> wordSet,List<String>  res) {
        if (end == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String str : queue) {
                stringBuilder.append(str);
                stringBuilder.append(" ");
            }

            System.out.println(stringBuilder.toString());
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            res.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < end; i++) {
            if (dp[i]) {
                String suffix = new String(s.substring(i,end));
                if (wordSet.contains(suffix)){
                    queue.addFirst(suffix);
                    backTrack(dp, s, i, queue, wordSet,res);
                    queue.removeFirst();
                }

            }

        }
    }
//    public void dfs(String s, int end, Set<String> wordSet, List<String> res, LinkedList<String> queue, boolean[] dp) {
//    if (end == 0) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (String word : queue) {
//            stringBuilder.append(word);
//            stringBuilder.append(" ");
//        }
//        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//        res.add(stringBuilder.toString());
//        return;
//    }
//
//    for (int i = 0; i < end; i++) {
//        if (dp[i]) {
//            String suffix = s.substring(i, end);
//            if (wordSet.contains(suffix)) {
//                queue.addFirst(suffix);
//                dfs(s, i, wordSet, res, queue, dp);
//                queue.removeFirst();
//            }
//        }
//    }
//}

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
//        Solution2 solution2 = new Solution2();
//        List<String> res = solution2.wordBreak(s, wordDict);
        WordBreak_140 test = new WordBreak_140();
        List<String> res1 = test.wordBreak(s,wordDict);
        System.out.println(res1);

    }

}
