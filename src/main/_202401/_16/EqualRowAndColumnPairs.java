package main._202401._16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// https://leetcode.com/problems/equal-row-and-column-pairs
public class EqualRowAndColumnPairs {
    public static void main(String[] args) {
        System.out.println("expect: 1, result:"
                + equalPairs(
                new int[][] {
                    {3, 2, 1}, {1, 7, 6}, {2, 7, 7}
                }
            )
        );

        System.out.println("expect: 3, result:"
                + equalPairs(
                new int[][]
                    {
                        {3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}
                    }
            )
        );

        System.out.println("expect: 2, result:"
                + equalPairs(
                new int[][]
                    {
                        {11, 1}, {1, 11}
                    }
            )
        );

        System.out.println("expect: 4, result:"
                + equalPairs(
                new int[][]
                    {
                        {11, 11}, {11, 11}
                    }
            )
        );

        System.out.println("expect: 48, result:"
                + equalPairs(
                new int[][]
                    {
                        {3, 3, 3, 6, 18, 3, 3, 3, 3, 3}
                        , {3, 3, 3, 3, 1, 3, 3, 3, 3, 3}
                        , {3, 3, 3, 3, 1, 3, 3, 3, 3, 3}
                        , {3, 3, 3, 3, 1, 3, 3, 3, 3, 3}
                        , {1, 1, 1, 11, 19, 1, 1, 1, 1, 1}
                        , {3, 3, 3, 18, 19, 3, 3, 3, 3, 3}
                        , {3, 3, 3, 3, 1, 3, 3, 3, 3, 3}
                        , {3, 3, 3, 3, 1, 3, 3, 3, 3, 3}
                        , {3, 3, 3, 1, 6, 3, 3, 3, 3, 3}
                        , {3, 3, 3, 3, 1, 3, 3, 3, 3, 3}
                    }
            )
        );
    }

    public static int equalPairs_fail2(int[][] grid) {
        int size = grid.length;
        int[][] reverseGrid = new int[size][size];
        int count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                reverseGrid[i][j] = grid[i][j];// 반대로 넣음
            }
        }// 2중 for end
        // 행과 열 비교
        for (int[] row : grid) {
            for (int[] reverse : reverseGrid) {
                if (Arrays.equals(row, reverse)) {
                    count++;
                }
            }
        }


        return count;
    }

    public static int equalPairs(int[][] grid) {
        int size = grid.length;
        int matchCount = 0;

        Map<String, Integer> rowMap = new HashMap<>();


        // 각 행(row)을 문자열로 저장
        for (int i = 0; i < size; i++) {
            StringBuilder rowKey = new StringBuilder();
            for (int j = 0; j < size; j++) {
                rowKey.append(grid[i][j]).append(",");
            }// for i end
            String key = rowKey.toString();
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }// for j end


        // 각 열(column)을 문자열로 저장
        for (int i = 0; i < size; i++) {
            StringBuilder colKey = new StringBuilder();
            for (int j = 0; j < size; j++) {
                colKey.append(grid[j][i]).append(",");
            }// for i end
            String key = colKey.toString();
            if (rowMap.containsKey(key)) {
                matchCount += rowMap.get(key);
            }
        }// for j end

        return matchCount;
    }


    public static int equalPairs_fail(int[][] grid) {
        int size = grid.length;
        int matchCount = 0;

        HashSet<String> rowSet = new HashSet<>();
        HashSet<String> columnSet = new HashSet<>();

        // 각 행(row)을 문자열로 저장
        for (int i = 0; i < size; i++) {
            String rowTemp = "";
            for (int j = 0; j < size; j++) {
                rowTemp += grid[i][j] - '0';

                if (j == size - 1 && !rowSet.add(rowTemp)) {
                    matchCount++;
                }

            }// for i end
        }// for j end


        // 각 열(column)을 문자열로 저장
        for (int i = 0; i < size; i++) {
            String colTemp = "";
            for (int j = 0; j < size; j++) {
                colTemp += grid[j][i] - '0';

                if (j == size - 1 && !columnSet.add(colTemp)) {
                    matchCount++;
                }

            }// for i end
        }// for j end


        System.out.println(rowSet);
        System.out.println(columnSet);

        // 교집합
        HashSet<String> sameSet = new HashSet<>(rowSet);
        sameSet.retainAll(columnSet);

        matchCount += sameSet.size();
        if ((size << 1) - 1 == matchCount) {
            return (size << 1);
        }
        return matchCount;
    }
}
