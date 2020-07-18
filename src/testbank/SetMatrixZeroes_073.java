package testbank;

public class SetMatrixZeroes_073 {
    public  static  void main(String[] args){

    }
    public  static void setZeroes(int[][] matrix){
        boolean rowflag=false;
        boolean colflag=false;

        int m=matrix.length;
        int n=matrix[0].length;

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j] ==0){
                    if (i==0){
                        rowflag=true;
                    }
                    if (j==0){
                        colflag=true;
                    }
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for (int i=1;i<n;i++){
            if (matrix[0][i]==0){
                for (int j=1;j<m;j++){
                    matrix[j][i]=0;
                }
            }
        }
        for (int i=1;i<m;i++){
            if (matrix[i][0]==0){
                for (int j=1;j<n;j++){
                    matrix[i][j]=0;
                }
            }
        }
        if (rowflag==true){
            for (int i=0 ;i<n;i++){
                matrix[0][i]=0;
            }
        }
        if (colflag==true){
            for (int i=0 ;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }

}
