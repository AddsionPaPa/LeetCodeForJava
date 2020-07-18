package testbank;

public class InterleavingString_097 {
    public static void main(String[] args) {
        InterleavingString_097 test= new InterleavingString_097();
        test.isInterleave("aabcc"
                ,"dbbca"
                ,"aadbbcbcac");

    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int length_s1 = s1.length();
        int length_s2 = s2.length();
        int length_s3 = s3.length();
        if (length_s1 + length_s2 != length_s3){
            return false;
        }
        boolean[][] dp = new boolean[length_s1 + 1][length_s2 + 1];
        dp[0][0]=true;
        for (int i=1;i<=length_s2;i++){
            dp[0][i]=dp[0][i-1] && (s2.charAt(i-1)==s3.charAt(i-1));
        }
        for (int j=1;j<=length_s1;j++){
            dp[j][0] = dp[j-1][0] && (s1.charAt(j-1) == s3.charAt(j-1));
        }
        for (int i=1;i<=length_s1;i++){
            for (int j=1;j<=length_s2;j++){
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        for (int i=0;i<=length_s1;i++){
            for (int j=0;j<=length_s2;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[length_s1][length_s2];
    }
}
