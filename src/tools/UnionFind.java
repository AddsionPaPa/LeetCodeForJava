package tools;

import org.junit.Test;

public class UnionFind {
    /**
     * 并查集
     * count 代表集合个数
     * parent[i] 代表i元素的父亲
     * rank[i] 代表i元素的等级
     */

    private int count = 0;
    private int[] parent;
    private int[] rank;

    public UnionFind(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        parent = new int[row*col];
        rank  = new int[row*col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    count++;
                    parent[i*col+j] = i*col+j;
                    rank[i*col+j] = 0;
                }
            }
        }
    }

    public int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    /**
     * 此处注意 必须用过root来比较 ， 否则会出现计算count错误
     * @param x
     * @param y
     */
    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);

        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            }
            else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
            count--;
        }
    }

    public int getCount() {
        return count;
    }



}
