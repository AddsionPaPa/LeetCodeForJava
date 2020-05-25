public class ClimbingStairs_070 {
    public static void main(String[] args){

    }

    public static int climbStairs(int n){
        if(n==1 || n==0)return 1;
        int[] array=new int[n+1];
        array[0]=0;
        array[1]=1;
        array[2]=2;
        for (int i=3;i<=n;i++){
            array[i]=array[i-1]+array[i-2];
        }
        return array[n];
    }
}
