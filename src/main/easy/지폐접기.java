package main.easy;

public class 지폐접기 {
    public static void main(String[] args) {

        System.out.println(new 지폐접기().solution(new int[] {30, 15}, new int[] {26, 17}));

    }

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int walletMin = Math.min(wallet[0], wallet[1]);
        int walletMax = Math.max(wallet[0], wallet[1]);

        while (true) {
            int billMin = Math.min(bill[0], bill[1]);
            int billMax = Math.max(bill[0], bill[1]);
            if (billMax <= walletMax && billMin <= walletMin) {
                break;
            }

            // 긴쪽을 접기
            if (bill[0] >= bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }

            answer++;
        }

        return answer;
    }

    public int solution2(int[] wallet, int[] bill) {
        // 길이가 긴쪽을 반으로 접는다
        // 소수점은 버린다


        // 가로 세로 중에 더 큰 값을 반으로 나누고, 가로 세로보다 작으면 수행 완료

        // 문제 1
        // 30, 15 : 26, 17 -> 26, 8
        // 문제 2
        // 50, 50: 100, 241 -> 50, 241 -> 50, 120 -> 50, 60 -> 50, 30


        int answer = 0;

        while (true) {
            if ((bill[0] > wallet[0] | bill[0] > wallet[1])) {
                bill[0] = bill[0] / 2;
                answer++;
                continue;
            }

            if ((bill[1] > wallet[0] | bill[1] > wallet[1])) {
                bill[1] = bill[1] / 2;
                answer++;
                continue;
            }

            break;
        }
        return answer;
    }
}
