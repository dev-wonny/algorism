package main._202501._08;

// https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
public class NetworkConnected {
    public static void main(String[] args) {
        System.out.println("expect:1 , result: " +
            makeConnected(
                4
                , new int[][] {
                    {0, 1}, {0, 2}, {1, 2}
                }
            )
        );

        System.out.println();
        System.out.println("expect:2 , result: " +
            makeConnected(
                6
                , new int[][] {
                    {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}
                }
            )
        );
        System.out.println();
        System.out.println("expect:-1 , result: " +
            makeConnected(
                6
                , new int[][] {
                    {0, 1}, {0, 2}, {0, 3}, {1, 2}
                }
            )
        );

        System.out.println();
        System.out.println("expect:13 , result: " +
            makeConnected(
                100
                , new int[][] {
                    {17, 51}, {33, 83}, {53, 62}, {25, 34}, {35, 90}, {29, 41}, {14, 53}, {40, 84}, {41, 64}, {13, 68}, {44, 85}, {57, 58}, {50, 74}, {20, 69}, {15, 62}, {25, 88}, {4, 56}, {37, 39},
                    {30, 62}, {69, 79}, {33, 85}, {24, 83}, {35, 77}, {2, 73}, {6, 28}, {46, 98}, {11, 82}, {29, 72}, {67, 71}, {12, 49}, {42, 56}, {56, 65}, {40, 70}, {24, 64}, {29, 51}, {20, 27},
                    {45, 88}, {58, 92}, {60, 99}, {33, 46}, {19, 69}, {33, 89}, {54, 82}, {16, 50}, {35, 73}, {19, 45}, {19, 72}, {1, 79}, {27, 80}, {22, 41}, {52, 61}, {50, 85}, {27, 45}, {4, 84},
                    {11, 96}, {0, 99}, {29, 94}, {9, 19}, {66, 99}, {20, 39}, {16, 85}, {12, 27}, {16, 67}, {61, 80}, {67, 83}, {16, 17}, {24, 27}, {16, 25}, {41, 79}, {51, 95}, {46, 47}, {27, 51},
                    {31, 44}, {0, 69}, {61, 63}, {33, 95}, {17, 88}, {70, 87}, {40, 42}, {21, 42}, {67, 77}, {33, 65}, {3, 25}, {39, 83}, {34, 40}, {15, 79}, {30, 90}, {58, 95}, {45, 56}, {37, 48},
                    {24, 91}, {31, 93}, {83, 90}, {17, 86}, {61, 65}, {15, 48}, {34, 56}, {12, 26}, {39, 98}, {1, 48}, {21, 76}, {72, 96}, {30, 69}, {46, 80}, {6, 29}, {29, 81}, {22, 77}, {85, 90},
                    {79, 83}, {6, 26}, {33, 57}, {3, 65}, {63, 84}, {77, 94}, {26, 90}, {64, 77}, {0, 3}, {27, 97}, {66, 89}, {18, 77}, {27, 43}
                }
            )
        );

        // Memory Limit Exceeded
    }

    /**
     * 모든 것을 연결하기 연결 하기 위해
     * 수정 해야할 최소 작업을 return
     */
    public static int makeConnected(int n, int[][] connections) {
        // 간선의 개수가 n-1보다 적으면 연결할 수 없음
        if (connections.length < n - 1) {
            return -1;
        }

        boolean[] checked = new boolean[n];// 공유 자원

        // 그래프를 만드는 부분
        int[][] graph = new int[n][n];// 공유 자원
        for (int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for (int[] g : graph) {
//            System.out.println("graph: " + Arrays.toString(g));
        }


        // 만들어진 그래프로 DFS 적용
        // stack 사용
        // 1) call stack -> 재귀함수
        // 모든 노드에 대해서 DFS 적용
        int networkCount = 0;
        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                networkCount++;
                DFS(i, checked, graph);
            }
        }
//        System.out.println("최종 networkCount:" + networkCount);
        // 2) stack 사용 == queue

        int isolationNetwork = 0;

        // 체킹이 되지 않은 개수
        for (int i = 0; i < checked.length; i++) {
            if (!checked[i]) {
                isolationNetwork++;
            }
        }

        return networkCount + isolationNetwork - 1;
    }

    private static void DFS(int startIndex, boolean[] checked, int[][] graph) {
//        System.out.println("call: " + startIndex);
        // 방문체크
        if (!checked[startIndex]) {
            checked[startIndex] = true;

            // 연결된 곳으로 간다
            int[] nextArr = graph[startIndex];
            for (int i = 0; i < nextArr.length; i++) {
                if (nextArr[i] == 1) {
//                    System.out.println("from: " + startIndex + ", to:" + i);
                    DFS(i, checked, graph);
                }
            }


        }
    }
}
