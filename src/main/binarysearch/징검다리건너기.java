package main.binarysearch;

public class 징검다리건너기 {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/64062
    한 번 밟을 때마다 1씩 줄어듭니다
     0이 되면 더 이상 밟을 수 없으
     한 번에 건너뛸 수 있는 디딤돌의 최대 칸수 k
     최대 몇 명까지 징검다리를 건널 수 있는지 return

    징검다리를 건너야 하는 니니즈 친구들의 수는 무제한
    stones 배열의 크기는 1 이상 200,000 이하
    stones 배열 각 원소들의 값은 1 이상 200,000,000 이하인 자연수
    k는 1 이상 stones의 길이 이하인 자연수
     */
    public static void main(String[] args) {
        //3
        System.out.println(new 징검다리건너기().solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }

    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200_000_000;// 최대 사람수

        int result = 0;

        while (left <= right) {
            int humanCount = (left + right) / 2;

            // 건널 수 있으면 더 많은 사람도 가능할지 오른쪽 탐색
            if (go(stones, k, humanCount)) {
                result = humanCount;
                left = humanCount + 1;
            }// if end

            // 못 건너면 줄여야 함
            else {
                right = humanCount - 1;
            }
        }//while end

        return result;
    }

    private boolean go(int[] stones, int k, int humanCount) {
        int skipCount = 0;

        for (int stone : stones) {
            if (stone < humanCount) {
                skipCount++;

                if (skipCount >= k) {
                    return false;
                }
            } else {
                skipCount = 0;//초기화
            }
        }

        return true;
    }

    public int solution2(int[] stones, int k) {
        int i = 0;//움직인 횟수
        int length = stones.length;

        while (true) {
            int index = i % length;
            int left = stones[index];

            //못건너면 건너뛰기 얼마나 가능?
            if (left <= 0) {
                boolean flag = false;
                for (int j = 0; j < k - 1; j++) {
                    int tempIndex = ++i % length;
                    int leftCount = stones[tempIndex];

                    if (leftCount > 0) {
                        flag = true;
                        stones[tempIndex] = leftCount - 1;
                        i++;
                        break;
                    }//if end
                }//for end

                if (!flag) {
                    break;
                }
            } else {
                stones[index] = left - 1;
                i++;
            }// else end
        }//while end
        int ans = i / length;

        return ans;
    }//end
}
