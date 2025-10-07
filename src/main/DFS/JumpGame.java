package main.DFS;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));//true
        System.out.println(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));//false
        System.out.println(new JumpGame().canJump(new int[]{0}));//true

        // Time Limit Exceeded error -> 데이터가 어마어마하게 많으면 시간 초과 발생 -> memozation 적용

        //java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
        System.out.println(new JumpGame().canJump(new int[]{2, 0}));//true
    }

    private enum JUMP {
        GOOD(1),
        BAD(2),
        UNKNOWN(0);
        final int val;

        JUMP(int val) {
            this.val = val;
        }

        public int val() {
            return val;
        }
    }

    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        memo[nums.length - 1] = JUMP.GOOD.val();// 마지막 칸은 GOOD
        return dfs(0, nums, memo);
    }

    private boolean dfs(int idx, int[] nums, int[] memo) {
        // good인지 bad인지 검증 필터링
        if (memo[idx] != JUMP.UNKNOWN.val()) {
            return memo[idx] == JUMP.GOOD.val();// 괜찮은지 체크
        }

        // 경계 내에서만 탐색
        int farthest = Math.min(idx + nums[idx], nums.length - 1);
        // 가장 멀리간 인덴스에서 줄여나간다, 큰 점프부터 시도, 현재 내 위치까지만 가능함
        for (int nextIdx = farthest; nextIdx > idx; nextIdx--) {
            // 내가 갈수 있는 최대치 ~ 현재 나의 위치까지 오기전에 중간에 GOOD이었다면 나도 GOOD을 전달 받는다
            if (dfs(nextIdx, nums, memo)) {
                memo[idx] = JUMP.GOOD.val();
                return true;
            }
        }//for end
        // 내가 갈수 있는 최대치 ~ 현재 나의 위치까지에서 GOOD이 없으므로 실패임
        memo[idx] = JUMP.BAD.val();
        return false;
    }

    //시간 O(n), 공간 O(1)
    public boolean canJump1(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;                 // 이 위치에 아예 못 오면 실패
            maxReach = Math.max(maxReach, i + nums[i]);     // 최원거리 갱신
            if (maxReach >= nums.length - 1) return true;   // 끝 도달 가능
        }
        return true; // 길이 1 등
    }

    public boolean canJump2(int[] nums) {
        if (nums.length == 1) return true;
        boolean[] visited = new boolean[nums.length];
        int currentPosition = 0;
        visited[0] = true;
        int max = nums[currentPosition];
        for (int i = max; i > 0; i--) {
            // 범위 넘어가는 것 예외 처리
            int nextIdx = currentPosition + i;
            if (nums.length <= nextIdx) {
                return true;
            }
            // 방문 검증
            if (visited[nextIdx]) {
                continue;
            }
            if (DFS(nums, nextIdx, visited)) {
                return true;
            }
        }// for end
        return false;
    }

    private boolean DFS(int[] nums, int currentPosition, boolean[] visited) {
        //방문 처리
        visited[currentPosition] = true;
        if (currentPosition >= nums.length - 1) {
            return true;
        }
        int max = nums[currentPosition];
        for (int i = max; i > 0; i--) {
            // 범위 넘어가는 것 예외 처리
            int nextIdx = currentPosition + i;
            if (nums.length <= nextIdx) {
                return true;
            }
            // 방문 검증
            if (visited[nextIdx]) {
                continue;
            }
            if (DFS(nums, nextIdx, visited)) {
                return true;
            }
        }// for end
        return false;
    }
}