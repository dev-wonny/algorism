import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CatchMe {

    public static void main(String[] args) {
        System.out.println(catchMe(11, 2)); // Expected output: 5
        System.out.println(catchMe(10, 3)); // Expected output: 3
        System.out.println(catchMe(51, 50)); // Expected output: 8
        System.out.println(catchMe(550, 500)); // Expected output: 28
    }

    public static int catchMe(int conyLoc, int brownLoc) {
        final int MAX_POSITION = 200000;

        // 방문 기록을 저장하는 배열 (시간의 홀짝으로 구분)
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        for (int i = 0; i <= MAX_POSITION; i++) {
            visited.put(i, new HashSet<>());
        }

        // BFS 탐색을 위한 큐 초기화
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {brownLoc, 0}); // {브라운의 현재 위치, 시간}

        int time = 0;

        // BFS 시작
        while (conyLoc <= MAX_POSITION) {
            // 코니의 현재 위치 갱신
            conyLoc += time;

            // 코니가 범위를 벗어날 경우 잡을 수 없음
            if (conyLoc > MAX_POSITION) {
                return -1;
            }

            // 브라운이 현재 시간에 코니의 위치를 방문했는지 확인
            if (visited.get(conyLoc).contains(time)) {
                return time;
            }

            // BFS로 브라운의 이동 경로 탐색
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currentPosition = current[0];
                int currentTime = current[1];

                // 브라운의 다음 가능한 이동 경로 계산
                int[] nextPositions = {
                    currentPosition - 1,
                    currentPosition + 1,
                    currentPosition * 2
                };

                for (int nextPosition : nextPositions) {
                    if (nextPosition >= 0 && nextPosition <= MAX_POSITION &&
                        !visited.get(nextPosition).contains(currentTime + 1)) {// 안 들어있으면
                        // 방문 처리
                        visited.get(nextPosition).add(currentTime + 1);// 시간 추가
                        queue.offer(new int[] {nextPosition, currentTime + 1});
                    }
                }
            }

            time++; // 시간 증가
        }

        return -1; // 잡을 수 없는 경우
    }
}
