public class UniquePathWithObstacles_063 {
    public static void main(String[] args){
        int[][] array={
                {0,0,0},{0,1,0},{0,0,0}
        };
        int t=uniquePathsWithObstacles(array);
        System.out.print(t);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
//        System.out.print(m+" "+n);
        int dp[][] = new int[m][n];
        boolean flag=true;
        for (int i=0;i<n;i++){
            if (obstacleGrid[0][i] ==0 && flag){
                dp[0][i]=1;
            }
            else {
                dp[0][i]=0;
                flag=false;
            }
        }
        flag=true;
        for(int i=0; i<m; i++){
            if (obstacleGrid[i][0] ==0 && flag){
                dp[i][0]=1;
            }
            else {
                dp[i][0]=0;
                flag=false;
            }
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
//        for (int i=0;i<m;i++){
//            for (int j=0;j<n;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.print('\n');
//        }
        return dp[m-1][n-1];
    }
}
