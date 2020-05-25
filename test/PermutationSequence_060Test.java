import junit.framework.TestCase;

import java.util.ArrayList;

public class PermutationSequence_060Test extends TestCase {

    public void testGetPermutation() {
        int n=3,k=3;
        int[] n_multi={1,1,2,6,24,120,720,5040,40320,360880};
        String res=new String("");
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        arrayList.clear();
        for(int i=0;i<n;i++){
            arrayList.add(i+1);
        }
        int tempk=k;
        int t=0;
        int tempn=n;
        int test=1;
        while (!arrayList.isEmpty()){
//            System.out.print(test++);
            t= (int) Math.ceil(tempk*1.0/n_multi[tempn-1])-1;
            if (t==-1){
                t=0;
            }
            System.out.print("t:"+t+"tempk"+tempk+"tempn"+tempn+"  ");
//            System.out.print(arrayList.get(t));
            String s=String.valueOf(arrayList.get(t));
            res+=s;
            System.out.print(res+'\n');
            tempn=tempn-1;
            tempk-=n_multi[tempn]*t;
            arrayList.remove(t);
        }
//        return res;
//        System.out.print(res);
    }

}