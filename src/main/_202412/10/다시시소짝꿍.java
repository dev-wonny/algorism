import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/152996
 * 순열, 수열
 * 백트래킹을 사용한다
 * <p>
 * <p>
 * 둘의 차이
 * 수열에서는 visited[i] = false; 사용
 * 순열(조합)에서는 visited[i] = false; 신경 안씀
 */
public class 다시시소짝꿍 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 풀이
        long result = solution.solution(new int[] {100, 180, 360, 100, 270});
        System.out.println("예상 결과: 4, 실제 값:" + result);

    }// main end

    static class Solution {
        public long solution(int[] weights) {

            // weights 정렬

            Arrays.sort(weights);


            // weights, 몇개 뽑아야하는지, 시작지점, 임시저장 리스트, 최종 결과 리스트

            List<Point> tempList = new LinkedList<Point>();
            backTracking(weights, 0, 1, tempList);

//            System.out.println("마지막:" + tempList.toString());
            return tempList.size();
        }// solution end


        public void backTracking(int[] weights, int startIndex, int nextIndex, List<Point> tempList) {
            // 고정값
            final int[] defaultArr = {4, 3, 2, 1};


            //방문하지 않은 곳이라면 계속 탐색한다
            // while ()

//            System.out.println("시작>>>>>>>" + startIndex + ", " + nextIndex);


            // breakpoint
            if (startIndex >= weights.length - 1 || nextIndex >= weights.length) {
                return;
            }


            int currentValue = weights[startIndex];
            int nextValue = weights[nextIndex];

            // 다음꺼랑 값 일치하면 tempList 추가
            if (currentValue == nextValue) {
                tempList.add(new Point(currentValue, nextValue));
//                System.out.println("같아서 추가: currentValue:" + currentValue + ", nextValue:" + nextValue);

            } else {
                for (int r = nextIndex; r < weights.length; r++) {
                    // 다음꺼랑 값 곱하기해서 일치하면 tempList 추가
                    for (int j : defaultArr) {

                        for (int k : defaultArr) {
                            System.out.println("(" + j + "," + k + ") 대기: currentValue:" + currentValue + ", nextValue:" + nextValue + ", 값:" + currentValue * j + "==" + nextValue * k);

                            if (currentValue * j == nextValue * k) {
                                tempList.add(new Point(currentValue, nextValue));
//                                System.out.println("추가: currentValue:" + currentValue + ", nextValue:" + nextValue);
                                break;
                            }
                        }

                    }
                }


                // weights를 비교를 하나씩 늘려간다
//                backTracking(weights, startIndex, ++nextIndex, tempList);
            }


//            System.out.println("다음으로 넘어가자>>>>>>>" + (startIndex + 1));
            backTracking(weights, ++startIndex, (startIndex + 1), tempList);


            // 야 끝났데, 백트래킹


        }

        public class Point {
            private int currentValue;
            private int nextValue;

            public Point(int currentValue, int nextValue) {
                this.currentValue = currentValue;
                this.nextValue = nextValue;
            }
        }


    }// class Solution end
}
