package cci;

import java.util.*;

public class findWhetherExistsPath_0401 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 初始化邻接矩阵
        List<Integer>[] matrix = new ArrayList[n];
        for (int i = 0; i < graph.length ; i++) {
            int from = graph[i][0];
            int to = graph[i][1];
            if (matrix[from] == null) {
                matrix[from] = new ArrayList<>();
            }
            matrix[from].add(to);
        }
        return bfs(matrix,start,target,n);
    }
    public boolean bfs(List<Integer>[] matrix,int start,int target,int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(visited, false);
        if (start == target) {
            return true;
        }
        queue.offer(start);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (temp == target) {
                return true;
            }
            visited[temp] = true;
            if (matrix[temp] != null) {
                for (Integer i : matrix[temp]) {
                    if (!visited[i]) {
                        queue.offer(i);
                    }
                }
            }

        }
        return false;
    }

}
