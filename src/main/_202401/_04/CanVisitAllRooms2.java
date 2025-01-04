package main._202401._04;

import java.util.List;

public class CanVisitAllRooms2 {
    public static void main(String[] args) {
        System.out.println("Expected output: true, " + canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
        System.out.println("Expected output: false, " + canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0))));
    }

    static boolean[] visited;
    static int count = 0;
    static List<List<Integer>> list;
    static int n;


    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        visited = new boolean[n];
        list = rooms;
        dfs(0);
        return count == n;
    }

    private static void dfs(int v) {
        if (visited[v] == true) {
            return;
        }
        visited[v] = true;
        count++;
        if (count == n) {
            return;
        }
        for (int node : list.get(v)) {
            dfs(node);
        }
    }
}
