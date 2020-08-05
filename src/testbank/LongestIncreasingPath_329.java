package testbank;

import org.junit.Test;

import java.util.Arrays;

public class LongestIncreasingPath_329 {


    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return  0;
        }

        int row =matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];

        int[][] count = new int[row][col];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i <row ; i++) {
            Arrays.fill(visited[i],false);
            Arrays.fill(count[i],1);
        }
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max,getCount(matrix,visited,count,i,j));
            }
        }
        return max;

    }

    public int getCount(int[][] matrix, boolean[][] visited, int[][] count, int i, int j) {
        int max = Integer.MIN_VALUE;
        int temp;
        if (visited[i][j]){
            return count[i][j];
        }

        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
            temp = getCount(matrix,visited,count,i,j-1);
            max= Integer.max(max,temp);
        }
        if (i > 0 && matrix[i][j] < matrix[i-1][j]) {
            temp = getCount(matrix,visited,count,i-1,j);
            max= Integer.max(max,temp);
        }
        if (j<matrix[0].length-1 && matrix[i][j] < matrix[i][j + 1]) {
            temp = getCount(matrix,visited,count,i,j+1);
            max= Integer.max(max,temp);
        }
        if (i<matrix.length-1 && matrix[i][j] < matrix[i+1][j]) {
            temp = getCount(matrix,visited,count,i+1,j);
            max= Integer.max(max,temp);
        }
        visited[i][j]=true;
        if (max == Integer.MIN_VALUE) {
            return 1;
        }
        count[i][j] = max+1;
        return max+1;
    }

    @Test
    public void fun() {
        System.out.println(longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));

    }
}
