public class EditDistance_072 {
    public static void main(String[] args){

    }
    public static int minDistance(String word1, String word2){
        int word1length=word1.length();
        int word2length=word2.length();

        int[][] dp=new int[word1length+1][word2length+1];
//        int count=0;
        for (int i=0 ;i<= word1length;i++){
            dp[i][0]=i;
        }
//        count=0;
        for (int i=0;i<= word2length;i++){
            dp[0][i]=i;
        }

        for (int i=1;i<word1length+1;i++){
            for (int j=1;j<word2length+1;j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                }
            }
        }

        return dp[word1length][word2length];
    }
}
