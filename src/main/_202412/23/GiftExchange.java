import java.util.HashMap;
import java.util.Map;

public class GiftExchange {
    public static void main(String[] args) {
        String[] friends1 = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts1 = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(solution(friends1, gifts1)); // 출력: 2

        String[] friends2 = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts2 = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        System.out.println(solution(friends2, gifts2)); // 출력: 4

        String[] friends3 = {"a", "b", "c"};
        String[] gifts3 = {"a b", "b a", "c a", "a c", "a c", "c a"};
        System.out.println(solution(friends3, gifts3)); // 출력: 0
    }

    public static int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> friendIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            friendIndex.put(friends[i], i);
        }

        int[][] giftCount = new int[n][n];
        int[] giftDegree = new int[n];

        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int giver = friendIndex.get(parts[0]);
            int receiver = friendIndex.get(parts[1]);
            giftCount[giver][receiver]++;
            giftDegree[giver]++;
            giftDegree[receiver]--;
        }

        int[] receivedGifts = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (giftCount[i][j] > giftCount[j][i]) {
                    receivedGifts[i]++;
                } else if (giftCount[i][j] < giftCount[j][i]) {
                    receivedGifts[j]++;
                } else {
                    if (giftDegree[i] > giftDegree[j]) {
                        receivedGifts[i]++;
                    } else if (giftDegree[i] < giftDegree[j]) {
                        receivedGifts[j]++;
                    }
                }
            }
        }

        int maxGifts = 0;
        for (int count : receivedGifts) {
            if (count > maxGifts) {
                maxGifts = count;
            }
        }

        return maxGifts;
    }
}
