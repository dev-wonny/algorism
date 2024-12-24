import java.util.LinkedList;
import java.util.Queue;

public class CatchCony {
    public static void main(String[] args) {
        System.out.println(solve(11, 2)); // Expected output: 5
        System.out.println(solve(10, 3)); // Expected output: 3
        System.out.println(solve(51, 50)); // Expected output: 8
        System.out.println(solve(550, 500)); // Expected output: 28
    }

    public static int solve(int conyPosition, int brownPosition) {
        final int MAX_POSITION = 200000; // 위치 범위
        boolean[][] visited = new boolean[MAX_POSITION + 1][2]; // 방문 여부: [위치][홀짝]

        // BFS를 위한 큐
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {brownPosition, 0}); // 초기 위치와 시간(홀짝 구분)

        int time = 0;

        // BFS 시작
        while (true) {
            // 코니의 위치 갱신
            conyPosition += time;
            if (conyPosition > MAX_POSITION) {
                return -1; // 코니가 범위를 벗어나면 종료
            }

            // 코니와 브라운이 같은 위치에서 만나는 경우
            if (visited[conyPosition][time % 2]) {
                return time;
            }

            // 브라운의 이동 탐색
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currentPosition = current[0];
                int currentTimeParity = current[1];

                // 브라운의 가능한 이동 위치 계산
                int[] nextPositions = {
                    currentPosition - 1, // 뒤로 이동
                    currentPosition + 1, // 앞으로 이동
                    currentPosition * 2  // 순간 이동
                };

                for (int nextPosition : nextPositions) {
                    if (nextPosition >= 0 && nextPosition <= MAX_POSITION &&
                        !visited[nextPosition][(currentTimeParity + 1) % 2]) {// 홀짝
                        visited[nextPosition][(currentTimeParity + 1) % 2] = true;
                        queue.offer(new int[] {nextPosition, (currentTimeParity + 1) % 2});
                    }
                }
            }

            time++; // 시간 증가
        }
    }
}
