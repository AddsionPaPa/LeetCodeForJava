package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ContinuousNumberSequence_57 {

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> lists = new LinkedList<>();
        if (target < 3) {
            return new int[][]{};
        }
        int left = 1;
        int right = 2;
        int end =(target/2)+1;
        int[][] res;
        while (right <= end) {
            int sum = (left+right)*(right-left+1)/2;
            if (sum == target) {
                lists.add(new ArrayList<>());
                for (int i = left; i <=right ; i++) {
                    lists.get(lists.size()-1).add(i);
                }
                if (left + 1 == right) {
                    right++;
                }
                left++;
            } else if (sum < target) {
                right++;
            }
            else {
                if (left + 1 == right) {
                    right++;
                }
                left++;
            }
        }
        res = new int[lists.size()][];
        for (int i = 0; i <lists.size() ; i++) {
            res[i] = new int[lists.get(i).size()];
            for (int j = 0; j < lists.get(i).size(); j++) {
                res[i][j]=lists.get(i).get(j);
            }
        }
        return res;
    }
}
