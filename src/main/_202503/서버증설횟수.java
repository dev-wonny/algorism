package main._202503;

public class 서버증설횟수 {
    public static void main(String[] args) {
        int[] players1 = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        서버증설횟수 서버증설횟수 = new 서버증설횟수();
        System.out.println("expect:7, result:" + 서버증설횟수.solution(players1, 3, 5));
    }

    private int solution(int[] players, int m, int k) {
        int resultCount = 0;
        int[] memoryServerArr = new int[players.length];

        for (int i = 0; i < players.length; i++) {
            int needCount = players[i] / m;

            // 메모리 조회
            int moreAddSever = needCount - memoryServerArr[i];

            // 결과에 추가
            if (moreAddSever > 0) {
                resultCount += moreAddSever;
            }

            //메모리에 k시간 동안 기록
            if (moreAddSever > 0) {
                for (int j = 0; j < k; j++) {
                    int tempIndex = i + j;
                    if (tempIndex < players.length) {
                        int tempValue = memoryServerArr[tempIndex];
                        memoryServerArr[tempIndex] = tempValue + moreAddSever;
                    }
                }//for k시간 end
            }
        }//for players[] end
        return resultCount;
    }//solution end

}
