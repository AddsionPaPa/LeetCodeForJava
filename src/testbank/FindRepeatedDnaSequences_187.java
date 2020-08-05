package testbank;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FindRepeatedDnaSequences_187 {

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> stringHashSet = new HashSet<>();
        List<String> res = new LinkedList<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i,i+10);

            if (stringHashSet.contains(str)&&!res.contains(str)){
                res.add(str);
            }
            else {
                stringHashSet.add(str);
            }
        }
        return res;
    }
}
