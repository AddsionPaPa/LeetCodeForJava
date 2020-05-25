import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {
    public int[][] insert(int[][] intervals,int [] newInterval){
        List<int[]> res=new ArrayList<>();
        int i=0;
        while(i < intervals.length && newInterval[0]>intervals[i][1]){
            res.add(intervals[i]);
            i++;
        }
        int[] temp =new int[]{newInterval[0],newInterval[1]};
        while (i< intervals.length && newInterval[1]>=intervals[i][0]){
            temp[0]=Math.min(temp[0],intervals[i][0]);
            temp[1]=Math.max(temp[1],intervals[i][1]);
            i++;
        }
        res.add(temp);
        while (i < intervals.length){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
