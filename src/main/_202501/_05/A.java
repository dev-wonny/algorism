package main._202501._05;

public class A {
    public static void main(String[] args) {

        System.out.println("expect:16 , result:" + solution(new int[] {1, 0, 2, 4}, new int[] {2, 2, 0, 5}, new int[] {3, 17, 7, 4, 5, 17}));
        System.out.println("expect:16 , result:" + solution(new int[] {1, 2, 0, 2, 3}, new int[] {2, 1, 2, 1, 2}, new int[] {4, 8, 18, 16, 20}));// 총비용은 17, 제한으로 16
        System.out.println("expect:8 , result:" + solution(new int[] {2, 2}, new int[] {4, 3}, new int[] {1, 1, 1, 1, 9, 1, 1}));
        System.out.println("expect:2 , result:" + solution(new int[] {1, 1}, new int[] {1, 1}, new int[] {1, 51, 1, 1, 9, 1, 1}));
        System.out.println("expect:1 , result:" + solution(new int[] {1, 1}, new int[] {1, 1}, new int[] {1, 1, 1, 1, 9, 1, 1}));
        System.out.println("expect:3 , result:" + solution(new int[] {0}, new int[] {1}, new int[] {1, 3}));
        System.out.println("expect:2 , result:" + solution(new int[] {0}, new int[] {1}, new int[] {1, 2}));
        System.out.println("expect:1 , result:" + solution(new int[] {0}, new int[] {0}, new int[] {1}));
        System.out.println("expect:-1 , result:" + solution(new int[] {1}, new int[] {1}, new int[] {1}));// error
    }

    public static int solution(int[] start, int[] dest, int[] limit) {
        // 길이가 N 1~30
        int N = start.length;
        if (N > 30 || N < 1) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int accumulateSum = 0;// 탑승요금

        // 지하철 0~K-1개 == 배열의 길이와 같음

        for (int i = 0; i < N; i++) {
            // 인접 이동 가능, 양방향 이동 가능
            int distance = Math.abs(start[i] - dest[i]);
            // 이동시 2 증가, 같은 역이면 이동요금 안냄
            int pay = (distance * 2) + 1;
            accumulateSum += pay;

            int tempMax = Math.max(start[i], dest[i]);

            max = Math.max(max, tempMax);
        }

        // K 역 번호: 2~50
        int K = limit.length;
        if (max >= K) {
            return -1;
        }
        // 요금한도 : start, dest에서 제일 큰수 찾음 5 -> limit[5]
        int limitPay = limit[max];

        // 한도보다 크면 limit[5] 리턴, 작으면 총합을 리턴
        if (limitPay < accumulateSum) {
            return limitPay;
        }
        // N보다 커야함
        if (accumulateSum < N) {// 입장료
            return N;
        }
        return accumulateSum;
    }
}
