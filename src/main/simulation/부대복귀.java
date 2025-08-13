package main.simulation;

import java.util.ArrayList;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/132266
public class 부대복귀 {
    public static void main(String[] args) {
        System.out.println(new 부대복귀().solution(
            3
            , new int[][] {{1, 2}, {2, 3}}
            , new int[] {2, 3}
            , 1
        ));//[1, 2]

        System.out.println(new 부대복귀().solution(
            3
            , new int[][] {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}}
            , new int[] {1, 3, 5}
            , 5
        ));//[2, -1, 0]

    }

    public int[] solution(
        int n
        , int[][] roads
        , int[] sources
        , int destination) {

        int[] resultArr = new int[sources.length];

        // n 를 미리 만들어
        List[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i] = new ArrayList<>();
            }
        }

        for (int i = 0; i < roads.length; i++) {
            int from = roads[i][0];
            int to = roads[i][1];
            map[from].add(to);
            map[to].add(from);
        }

        for (int i = 0; i < sources.length; i++) {
            int source = sources[i];
            //목적지가 같으면 0
            if (source == destination) {
                resultArr[i] = 0;
            }

            // 탐색하기 거리
            List list = map[source];
            for (int j = 0; j < list.size(); j++) {
                int tmp = (int) list.get(j);
                if (tmp == destination) {
                    resultArr[i] = j + 1;
                }
            }// j for end


        }// i for end

        return resultArr;
    }
}
