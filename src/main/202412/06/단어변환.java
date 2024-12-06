import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */
public class 단어변환 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println("예상: 4, result: " + result);

        int result2 = solution.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"});
        System.out.println("예상: 0, result: " + result2);

    }

    static class Solution {
        public int solution(String begin, String target, String[] words) {
            //정렬
            Arrays.sort(words);
            return BFS(begin, target, words);
        }

        public int BFS(String begin, String target, String[] words) {
            //공통 변수
            boolean[] visited = new boolean[words.length];
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(begin, 0));

            // 비슷한 단어좀 찾아볼까 큐가 있을동안 돌려
            while (!queue.isEmpty()) {
                Point current = queue.poll();

                // 브레이크 포인트
                if (current.word.equals(target)) {
                    return current.distance;
                }

                // words[] 뒤지기, 글자 비교
                for (int i = 0; i < words.length; i++) {
                    if (!visited[i]) {
                        final String[] beginArr = current.word.split("");
                        final String[] targetArr = words[i].split("");
                        int count = 0;

                        // 단어 일치하는지 비교
                        for (int j = 0; j < begin.length(); j++) {
                            if (beginArr[j].equals(targetArr[j])) {
                                count++;
                            }
                        }

                        //일차하는 단어가 2개 이상이면 그걸 채택한다
                        if (count >= begin.length() - 1) {
                            visited[i] = true;
                            queue.add(new Point(words[i], ++current.distance));
                        }
                        //아니라면 스쳐가세요
                    }// if end
                }// for end
            }// while end
            return 0; // 도달 못해
        }//bfs end

        private class Point {
            private String word;
            private int distance;

            public Point(String word, int distance) {
                this.word = word;
                this.distance = distance;
            }
        }
    }// Solution class end

}// one class end