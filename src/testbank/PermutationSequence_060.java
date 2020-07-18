package testbank;

import java.util.ArrayList;

public class PermutationSequence_060 {
    public String getPermutation(int n,int k){
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
            t=(int)Math.ceil(tempk/n_multi[tempn-1]);
//            System.out.print(t);
//            System.out.print(arrayList.get(t));
            String s=String.valueOf(arrayList.get(t));
            res+=s;
            tempn=tempn-1;
            tempk-=n_multi[tempn]*t;
            arrayList.remove(t);
        }
        return res;
//        System.out.print(res);
    }
}
