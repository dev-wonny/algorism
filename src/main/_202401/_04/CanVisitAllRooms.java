package main._202401._04;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CanVisitAllRooms {
    public static void main(String[] args) {
        System.out.println("Expected output: true, " + canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
        System.out.println("Expected output: false, " + canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0))));
    }


    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(0);
        queue.add(0);

        while (!queue.isEmpty()) {
            int room = queue.poll();
            for (int key : rooms.get(room)) {
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(key);
                }
            }
        }

        return visited.size() == rooms.size();
    }
}
