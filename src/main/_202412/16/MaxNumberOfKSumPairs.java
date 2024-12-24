import java.util.Arrays;
import java.util.HashMap;

/**
 * (1) Two Pointer (maxOperations)
 * 정렬 후 배열 자체를 사용하는 방식이므로 추가 메모리가 필요하지 않습니다.
 * 공간 복잡도: O(1) (입력 배열을 제외하고 추가 메모리 없음).
 * <p>
 * (2) HashMap (maxOperations2)
 * 해시맵에 최대 배열 크기만큼의 데이터를 저장할 수 있습니다.
 * 공간 복잡도: O(n) (해시맵에 추가로 저장되는 데이터 크기).
 * DEFAULT_INITIAL_CAPACITY = 1 << 4 -> HashMap은 16개의 빈 버킷으로 시작
 * 최소 용량(capacity) = ceil(100,000 / 0.75) = 약 133,334.
 * 버킷 배열 사용: 각 버킷은 참조 타입으로 4~8 bytes 사용.
 * 버킷 배열 사용: 메모리 사용량 = 131,072 × 8 bytes = 약 1 MB.
 * <p>
 * 정리:
 * 시간 우선: maxOperations2 (HashMap 방식) → 더 빠름 (O(n)),약 100,000번의 연산
 * 공간 우선: maxOperations (Two Pointer 방식) → 메모리 효율적 (O(1)), 약 1,700,000번의 연산
 * <p>
 * 조건:
 * 1 <= nums.length <= 10^5
 * <p>
 * 결론:
 * HashMap 방식이 적합
 */

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        int result1 = Solution.maxOperations(new int[] {1, 2, 3, 4}, 5);
        System.out.println("expect:2, result:" + result1);


        int result2 = Solution.maxOperations(new int[] {3, 1, 3, 4, 3}, 6);
        System.out.println("expect:1, result:" + result2);


        int result3 = Solution.maxOperations2(new int[] {1, 2, 3, 4}, 5);
        System.out.println("expect:2, result:" + result3);


        int result4 = Solution.maxOperations2(new int[] {3, 1, 3, 4, 3}, 6);
        System.out.println("expect:1, result:" + result4);
    }

    /**
     * https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75
     */

    static class Solution {

        /**
         * 정렬: Arrays.sort(nums) → O(n log n)
         * 탐색: 한 번의 반복으로 O(n)
         * 총합: O(n log n)
         */
        static public int maxOperations(int[] nums, int k) {
            Arrays.sort(nums);

            int pL = 0;
            int pR = nums.length - 1;
            int matchedCount = 0;

            while (pL < pR) {

                int tempSum = nums[pL] + nums[pR];

                if (tempSum == k) {
                    matchedCount++;
                    pL++;
                    pR--;

                } else if (tempSum < k) {
                    pL++; // 합이 k보다 작으면 왼쪽 포인터를 이동 (작은 값을 증가)
                } else {
                    pR--; // 합이 k보다 크면 오른쪽 포인터를 이동 (큰 값을 감소)
                }

            }
            return matchedCount;
        }// end

        /**
         * hashMap 사용
         * 탐색: 한 번의 반복으로 O(n)
         */
        static public int maxOperations2(int[] nums, int k) {
            int matchedCount = 0;
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                // 필요한 값
                int needNum = k - num;

                // 필요한 값이 있으면 카운트를 올린다
                if (map.getOrDefault(needNum, 0) > 0) {
                    matchedCount++;
                    // 값 하나를 없앤다
                    map.put(needNum, map.get(needNum) - 1);
                } else {
                    // hashmap에 추가
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
            return matchedCount;
        }
    }
}
