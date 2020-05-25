public class minPathSum_064 {
    public static void main(String[] args){

    }
    public static int minPathSum(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++){
            if (i==0){
                dp[i][0]=grid[0][0];
            }
            else {
                dp[i][0] = dp[i-1][0] + grid[i][0];
            }
        }
        for (int i=1 ; i<n; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}
