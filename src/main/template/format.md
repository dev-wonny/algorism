```java
public static void main(String[] args) {
        Solution solution = new Solution();

        // 풀이
        int result = solution.solution(3, 5
            , new int[][]
                {
                    {10, 60, 1}
                    , {15, 100, 3}
                    , {20, 30, 1}
                    , {30, 50, 3}
                    , {50, 40, 1}
                    , {60, 30, 2}
                    , {65, 30, 1}
                    , {70, 100, 2}
                }
        );
        System.out.println("예상 결과: 25, 실제 값:" + result);

        System.out.println();
        System.out.println();
        System.out.println();

        int result2 = solution.solution(3, 5
            , new int[][]
                {
                    {5, 55, 2}
                    , {10, 90, 2}
                    , {20, 40, 2}
                    , {50, 45, 2}
                    , {100, 50, 2}
                }
        );
        System.out.println("예상 결과:90, 실제 값:" + result2);

    }// main end

    static class Solution {
        public int solution(int k, int n, int[][] reqs) {
            int answer = 0;
            return answer;
        }// solution end

    }// class Solution end
```