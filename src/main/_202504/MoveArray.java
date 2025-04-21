package main._202504;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MoveArray {
    public static void main(String[] args) {
        MoveArray o = new MoveArray();
        System.out.println(o.solution(new int[] {1, 2, 1}));//[1, 2, 1] −> [1, 2, 2] −> [1, 2, 3] -> 2
        System.out.println(o.solution(new int[] {2, 1, 4, 4}));//[2, 1, 3, 4] or [2, 1, 4, 3] -> 1
        System.out.println(o.solution(new int[] {6, 2, 3, 5, 6, 3}));//[6, 2, 1, 5, 4, 3] -> 4
//        System.out.println(o.solution(new int[] {}));
    }

    public int solution(int[] A) {
        int N = A.length;
        Set<Integer> target = new HashSet<>();
        for (int i = 1; i < N + 1; i++) {
            target.add(i); // 1~N이 있어야 함
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : A) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // 1. 우선 중복 없는 값은 target에서 제거
        for (int key : freq.keySet()) {
            if (target.contains(key)) {
                target.remove(key); // 올바른 자리 하나만 유지
            }
        }

        // 2. 중복된 값들 처리
        int moveCount = 0;
        List<Integer> spare = new ArrayList<>(target); // 빈 자리들
        Collections.sort(spare); // 오름차순으로 채우기

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();

            int duplicates = count - 1;
            while (duplicates-- > 0 && !spare.isEmpty()) {
                int empty = spare.remove(0);//빈자리 하나 꺼냄
                moveCount += Math.abs(val - empty);//이동 비용 계산
            }
        }

        return moveCount > 1_000_000_000 ? -1 : moveCount;
    }

//
//    public int solution(int[] A) {
//        //1~N까지 무조건 값이 있어야함
//        int length = A.length;
//
//        int moveCount = 0;
//
//        return moveCount > 1_000_000_000 ? -1 : moveCount;
//    }

//    public int solution(int[] A) {
//        //1~N까지 무조건 값이 있어야함
//        int length = A.length;
//        Set<Integer> used = new HashSet<>();
//        int moveCount = 0;
//
//        for (int num : A) {
//            int candidate = num;
//            int step = 0;
//
//            // 가장 가까운 비사용 숫자 찾기
//            while (used.contains(candidate)) {
//                step++;
//
//                // 먼저 왼쪽
//                if (!used.contains(num - step)) {
//                    candidate = num - step;
//                    break;
//                }
//
//                // 오른쪽
//                if (!used.contains(num + step)) {
//                    candidate = num + step;
//                    break;
//                }
//            }
//
//            moveCount += Math.abs(num - candidate);
//            used.add(candidate);
//        }
//
//        return moveCount > 1_000_000_000 ? -1 : moveCount;
//    }

//    public int solution(int[] A) {
//        int moves = 0;
//        Map<Integer, Integer> freq = new HashMap<>();
//        Set<Integer> used = new HashSet<>();
//        for (int a : A) {
//            freq.put(a, freq.getOrDefault(a, 0) + 1);
//        }//for end
//
//        Queue<Integer> queue = new LinkedList<>();
//
//        for (int key : freq.keySet()) {
//            used.add(key);
//            Integer countValue = freq.get(key);
//            for (int i = 1; i < countValue; i++) {
//                queue.add(key);
//            }
//
//
//        }//for end
//
//        while (!queue.isEmpty()) {
//            int num = queue.poll();
//            int offset = 1;
//
//            while (true) {
//                if (!used.contains(num - offset)) {
//                    used.add(num - offset);
//                    moves += offset;
//                    break;
//                }
//                if (!used.contains(num + offset)) {
//                    used.add(num + offset);
//                    moves += offset;
//                    break;
//                }
//                offset++;
//            }//while end
//        }//while end
//
//
//        return moves;
//    }


//    public int solution(int[] A) {
//        Arrays.sort(A);
//        Set<Integer> used = new HashSet<>();
//        int moves = 0;
//
//        for (int num : A) {
//            int current = num;
//            while (used.contains(current)) {
//                current++;
//                moves++;
//                if (moves > 1_000_000_000) {
//                    return -1;
//                }
//            }
//            used.add(current);
//        }
//
//        return moves;
//    }

//    public int solution(int[] A) {
//        int N = A.length;
//        int[] freq = new int[2 * N + 2]; // 충분히 넉넉한 배열 확보
//        for (int num : A) {
//            freq[num]++;
//        }
//
//        long moves = 0;
//
//        for (int i = 1; i < freq.length - 1; i++) {
//            if (freq[i] > 1) {
//                int extra = freq[i] - 1;
//                freq[i + 1] += extra;
//                moves += extra;
//                freq[i] = 1;
//            }
//        }
//
//        return moves > 1_000_000_000 ? -1 : (int) moves;
//    }

//    public int solution(int[] A) {
//        Set<Integer> used = new HashSet<>();
//        int moveCount = 0;
//
//        for (int num : A) {
//            int candidate = num;
//            int step = 0;
//
//            while (used.contains(candidate)) {
//                step++;
//
//                if (!used.contains(num - step)) {
//                    candidate = num - step;
//                    break;
//                }
//
//                if (!used.contains(num + step)) {
//                    candidate = num + step;
//                    break;
//                }
//            }//while end
//            moveCount += Math.abs(num - candidate);
//            used.add(candidate);
//        }//for end
//
//        return moveCount > 1_000_000_000 ? -1 : moveCount;
//
//    }

//    public int solution2(int[] A) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//
//
//        for (int ele : A) {
//            hashMap.put(ele, hashMap.getOrDefault(ele, 0) + 1);
//            min = Math.min(min, ele);
//            max = Math.max(max, ele);
//        }
//        int size = max + A.length + 2;
//        int[] check = new int[size];
//
//        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
//            check[entry.getKey()] = entry.getValue();
//        }
//
//        int moveCount = 0;
//
//        for (int i = min; i < size - 1; i++) {
//            while (check[i] > 1) {
//                check[i]++;
//                check[i + 1]++;
//                moveCount++;
//                if (moveCount > 1_000_000_000) {
//                    return -1;
//                }
//            }
//
//        }
//
//        return moveCount;
//    }

//    public int solution3(int[] A) {
//        TreeSet<Integer> used = new TreeSet<>();
//        int moveCount = 0;
//
//        for (int num : A) {
//            if (!used.contains(num)) {
//                used.add(num);
//                continue;
//            }
//
//            // 왼쪽, 오른쪽 후보 찾기
//            int offset = 1;
//            while (true) {
//                int left = num - offset;
//                int right = num + offset;
//
//                if (!used.contains(left)) {
//                    used.add(left);
//                    moveCount += offset;
//                    break;
//                }
//
//                if (!used.contains(right)) {
//                    used.add(right);
//                    moveCount += offset;
//                    break;
//                }
//
//                offset++;
//                if (offset > 1_000_000_000) {
//                    return -1;
//                }
//            }
//        }
//
//        return moveCount;
//    }
}
