package offer;

import java.util.Arrays;

public class RobotsRange_13 {
    public int count = 0;
    public boolean[][] visited;
    public int row;
    public int col;
    public int sum;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        for (int i = 0; i <m ; i++) {
            Arrays.fill(visited[i],false);
        }


        row = m;
        col = n;
        sum = k;
        dfs(m,n);
        return count;
    }

    public void dfs(int i, int j) {
        int left = i;
        int right = j;
        if (left / 10 + left % 10 + right / 10 + right % 10 <= sum) {
            count++;
            visited[i][j] = true;
            if ( i > 0&&!visited[i - 1][j] ) {
                dfs(i-1,j);
            }
            if (  i + 1 < row&&!visited[i + 1][j]) {
                dfs(i+1,j);
            }
            if (j > 0&& !visited[i][j - 1] ) {
                dfs(i,j-1);
            }
            if (j + 1 < col&& !visited[i][j + 1] ) {
                dfs(i,j+1);
            }
        }


    }
}
