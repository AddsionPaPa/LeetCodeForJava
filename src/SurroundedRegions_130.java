public class SurroundedRegions_130 {
    public class UnionFind {
        public int[] parents;

        public UnionFind(int totalNodes) {
            parents=new int[totalNodes];
            for (int i = 0; i < totalNodes; i++) {
                parents[i]=i;
            }
        }

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                parents[root2] = root1;
            }
        }

        public int find(int node) {
            while (parents[node] != node) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }

        public boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }
    }

    public static void main(String[] args) {
        SurroundedRegions_130 test = new SurroundedRegions_130();
        char[][] c= {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        test.solve(c);
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rows= board.length;
        int cols = board[0].length;
        UnionFind unionFind = new UnionFind(rows*cols+1);
        int exclusiveNode = rows*cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        unionFind.union(i*cols+j,exclusiveNode);
                    } else {
                        if (board[i][j + 1] == 'O' && !unionFind.isConnected(i * cols + j, i * cols + j + 1)) {
                            unionFind.union(i * cols + j, i * cols + j + 1);
                        }
                        if (board[i][j - 1] == 'O' && !unionFind.isConnected(i * cols + j, i * cols + j - 1)) {
                            unionFind.union(i * cols + j, i * cols + j - 1);
                        }
                        if (board[i-1][j] == 'O' && !unionFind.isConnected(i * cols + j, (i-1) * cols + j)) {
                            unionFind.union(i * cols + j, (i-1) * cols + j);
                        }
                        if (board[i+1][j] == 'O' && !unionFind.isConnected(i * cols + j, (i+1) * cols + j)) {
                            unionFind.union(i * cols + j, (i+1) * cols + j);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!unionFind.isConnected(i*cols+j,exclusiveNode)) {
                    board[i][j] = 'X';
                }
            }
        }

    }


}
