import javafx.util.Pair;

import java.util.*;

public class WordLadder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /**
         * 1.处理wordlist
         * 2.BFS 操作
         */
        Map<String, List<String>> all_general_word = new HashMap<>();
        for (String str :
                wordList) {
            int str_length=str.length();
            for (int i = 0; i < str_length; i++) {
                String new_str = str.substring(0,i)+"*"+str.substring(i+1,str_length);
                List<String> list = all_general_word.getOrDefault(new_str,new ArrayList<>());
                list.add(str);
                all_general_word.put(new_str,list);
            }
        }

        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        Map<String,Boolean> visited = new HashMap();
        visited.put(beginWord,true);
        queue.offer(new Pair<>(beginWord,1));

        while (!queue.isEmpty()) {
            Pair<String,Integer> pair = queue.poll();
            String pair_str = pair.getKey();
            int level = pair.getValue();
            int pair_str_length = pair_str.length();
            for (int i = 0; i < pair_str.length(); i++) {
                String pair_substr = pair_str.substring(0,i)+"*"+pair_str.substring(i+1,pair_str_length);

                for (String str:all_general_word.getOrDefault(pair_substr,new ArrayList<>())
                     ) {
                    if (str.equals(endWord)) {
                        return level+1;
                    }
                    if (!visited.containsKey(str)) {
                        visited.put(str,true);
                        queue.offer(new Pair<>(str,level+1));
                    }
                }
            }
        }

        return 0;
    }
}
