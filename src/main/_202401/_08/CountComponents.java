package main._202401._08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountComponents {

    public static void main(String[] args) {
        System.out.println("expect: 2, result: " + countComponents(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}));
        System.out.println("expect: 1, result: " + countComponents(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}}));
        System.out.println("expect: 3, result: " + countComponents(6, new int[][] {{0, 1}, {2, 3}, {4, 5}}));
    }

    public static int countComponents(int n, int[][] edges) {
        // 그래프를 인접 리스트로 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int v0 = edge[0];
            int v1 = edge[1];
            graph.get(v0).add(v1);
            graph.get(v1).add(v0);
        }

        // 방문한 노드를 기록하기 위한 Set
        Set<Integer> visited = new HashSet<>();
        int compCount = 0;

        // 각 노드에 대해 DFS 수행
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                compCount++;
                dfs(i, graph, visited);
            }
        }

        return compCount;
    }

    private static void dfs(int start, List<List<Integer>> graph, Set<Integer> visited) {
        // 스택을 사용한 DFS
        Set<Integer> seen = new HashSet<>();
        List<Integer> stack = new ArrayList<>();
        stack.add(start);
        seen.add(start);

        while (!stack.isEmpty()) {
            int current = stack.remove(stack.size() - 1);
            visited.add(current);

            for (int neighbor : graph.get(current)) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    stack.add(neighbor);
                }
            }
        }
    }
}
