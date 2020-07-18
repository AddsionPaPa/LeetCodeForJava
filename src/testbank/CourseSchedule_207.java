package testbank;

import tools.Node;

import java.util.Arrays;
import java.util.Stack;

public class CourseSchedule_207 {
    public boolean canFinish(int course, int[][] prerequisites) {
        if (prerequisites.length == 1 || prerequisites.length == 0) {
            return true;
        }
        int n = course;
        int[] input_edges = new int[n];
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(visited, false);
        Arrays.fill(input_edges, 0);
        Node[] total_nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            total_nodes[i] = new Node(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            input_edges[prerequisites[i][0]]++;
            total_nodes[prerequisites[i][1]].next.add(prerequisites[i][0]);
        }
        for (int i = 0; i < n; i++) {
            if (input_edges[i] == 0) {
                stack.push(i);
            }
        }

        while (!stack.empty()) {
            int pop_item = stack.pop();
            visited[pop_item] = true;
            for (Integer i : total_nodes[pop_item].next) {
                input_edges[i]--;
                if (input_edges[i] == 0) {
                    stack.push(i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }
}
