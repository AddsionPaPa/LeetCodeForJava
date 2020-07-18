package testbank;

public class SpiralMatrixII_059 {
    public int[][] generateMatrix(int n){
        int res[][]=new int[n][n];
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;
        int num=1;
        while(true){
            for(int i=left;i<=right;i++){
                res[top][i]=(num++);
            }
            top++;
            if(top>bottom)break;
            for(int i=top;i<=bottom;i++){
                res[i][right]=num++;
            }
            right--;
            if(right<left)break;
            for(int i=right;i>=left;i--){
                res[bottom][i]=num++;
            }
            bottom--;
            if(bottom<top)break;
            for (int i=bottom;i>=top;i--){
                res[i][left]=num++;
            }
            left++;
            if(left>right)break;
        }
        return res;
    }
}
