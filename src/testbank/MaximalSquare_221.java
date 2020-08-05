package testbank;

public class MaximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return  0;
        }
        int max =0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i <matrix[0].length ; i++) {
            dp[0][i] = matrix[0][i]-'0';
        }
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0]= matrix[i][0]-'0';
        }

        for (int i = 1; i < matrix.length ; i++) {
            for (int j = 1; j < matrix[0].length ; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] =1+ Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                   max = Math.max(dp[i][j],max);
                }
            }
        }
        return max*max;
    }
}
