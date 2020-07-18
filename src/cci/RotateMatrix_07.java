package cci;

public class RotateMatrix_07 {
    public static void main(String[] args) {
        int[][] a = new int[3][3];
        a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(a);
    }

    /**
     * 外层向内层逐层旋转
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length == 0 || length == 1) {
            return;
        }
        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - i - 1; j++) {
                int left_top = matrix[i][j];
                int right_top = matrix[j][length - i - 1];
                int left_bottom = matrix[length - 1 - j][i];
                int right_bottom = matrix[length - i - 1][length - j - 1];

                matrix[i][j] = left_bottom;
                matrix[j][length-i-1] = left_top;
                matrix[length -j -1][i] =right_bottom;
                matrix[length - i -1][length-j-1] = right_top;
            }

        }

    }
}
