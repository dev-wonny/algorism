import java.util.ArrayDeque;
import java.util.Queue;

public class Catch {


    public static void main(String[] args) {

        catchGame(10, 2);

    }

    public static int catchGame(int a, int b) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(b);

        for (int i = 1; i < 200000; i++) {
            int target = a + i;

            if (!queue.isEmpty()) {
//                BFS(target, queue.poll(), i);
            }

        }

        return 0;
    }

    private int BFS(int target, Integer currentB, int i) {

        int a = currentB + 1;
        int b = currentB - 1;
        int c = currentB * 2;

        if (target == a || target == b || target == c) {
            return i;
        }


//        BFS()

        return 0;

    }


}
