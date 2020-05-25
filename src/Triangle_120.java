import java.util.ArrayList;
import java.util.List;

public class Triangle_120 {
    public static void main(String[] args) {
        Triangle_120 test=new Triangle_120();
        List<List<Integer>> a=new ArrayList<>();
        List<Integer> a1=new ArrayList<>();
        a1.add(2);
        List<Integer> a2=new ArrayList<>();
        a2.add(3);
        a2.add(4);
        List<Integer> a3=new ArrayList<>();
        a3.add(6);
        a3.add(5);
        a3.add(7);
        List<Integer> a4=new ArrayList<>();
        a4.add(4);
        a4.add(1);
        a4.add(8);
        a4.add(3);
        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(a4);
        test.minimumTotal(a);
        System.out.print(a);
    }
    public int minimumTotal(List<List<Integer>> triangle) {

        int len=triangle.size();
        if (len == 0) {
            return 0;
        }
        if (len==1){
            return triangle.get(0).get(0);

        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int temp=triangle.get(i).get(j);
                triangle.get(i).set(j,temp+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
