package testbank;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i - 1; j++) {
                temp.add(res.get(i-2).get(j)+res.get(i-2).get(j-1));
            }
            if (i != 1) {
                temp.add(1);
            }
            res.add(temp);
        }
        return res;
    }
}
