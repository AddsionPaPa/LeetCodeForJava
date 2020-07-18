package testbank;

public class DecodeWays_091 {
    public static void main(String[] args){
        DecodeWays_091 test=new DecodeWays_091();
        System.out.println(test.numDecodings("17"));

    }
    public int numDecodings(String s){
        int length=s.length();
        if (length==0 || s.charAt(0)=='0' ){
            return 0;
        }
        int[] dp=new int[length+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<length+1;i++){
            if (s.charAt(i-1)=='0'){
                if (s.charAt(i-2)!='1' && s.charAt(i-2)!='2'){
                    return 0;
                }
                dp[i]=dp[i-2];
            }
            else {
                if ((s.charAt(i-2)=='1') || (s.charAt(i-2)=='2'&& s.charAt(i-1)>='1' && s.charAt(i-1)<='6')){

                    dp[i] = dp[i - 1] + dp[i - 2];

                }
                else {
                    dp[i]=dp[i-1];
                }
            }
        }
        return dp[length];
    }
}
