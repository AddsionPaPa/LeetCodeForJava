import java.util.ArrayList;
import java.util.List;

public class GrayCode_089 {
    public static void main (String[] args){

    }
    public List<Integer> grayCode(int n){
        List<Integer> res= new ArrayList<Integer>();
        res.add(0);
        int head=1;
        for (int i=1; i<=n;i++){
            for (int j=res.size()-1  ; j>=0;j--){
                int temp=res.get(j);
                res.indexOf(j);
                res.add(temp+head);
            }
            head<<=1;
        }
        return res;
    }
}
