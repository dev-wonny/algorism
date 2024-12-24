import java.util.HashMap;
import java.util.Map;

public class 가장많이받은선물 {
    public static void main(String[] args) {
        System.out.println(
            solution(
                new String[] {"muzi", "ryan", "frodo", "neo"},
                new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}
            )
        ); // Expected output: 2


        System.out.println(
            solution(
                new String[] {"joy", "brad", "alessandro", "conan", "david"},
                new String[] {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}
            )
        ); // Expected output: 4


        System.out.println(
            solution(
                new String[] {"a", "b", "c"},
                new String[] {"a b", "b a", "c a", "a c", "a c", "c a"}
            )
        ); // Expected output: 0

    }


    public static int solution(String[] friends, String[] gifts) {

        int max = 0;

        // 이중배열 표 만들기
        int[][] doubleArr = new int[friends.length][friends.length];
        Map<String, Integer> giverMap = new HashMap<>();
        Map<String, Integer> takerrMap = new HashMap<>();
        Map<String, Integer> presentMap = new HashMap<>();
        Map<String, Integer> winMap = new HashMap<>();

        for (String gift : gifts) {
            String[] split = gift.split(" ");

            // total 비교를 위한 작업
            giverMap.put(split[0], giverMap.getOrDefault(split[0], 0) + 1);// 준 개수 합
            takerrMap.put(split[1], takerrMap.getOrDefault(split[1], 0) + 1);// 받은 개수 합

            // doubleArr 만들기
            for (int i = 0; i < friends.length; i++) {
                for (int j = 0; j < friends.length; j++) {

                    // 일치하는 이름에 점수 넣기
                    if (friends[i].equals(split[0]) && friends[j].equals(split[1])) {
                        doubleArr[i][j] += 1;
                    }

                }
            }
        }

        // 선물 지수 구하기
        for (int i = 0; i < friends.length; i++) {
            String name = friends[i];
            int temp = giverMap.getOrDefault(name, 0);
            int temp2 = takerrMap.getOrDefault(name, 0);
            presentMap.put(name, temp - temp2);
        }
//        System.out.println("선물 지수:" + presentMap);

        // 개개인 비교
        for (int i = 0; i < doubleArr.length; i++) {
            for (int j = 0; j < doubleArr.length; j++) {

                if (i != j) {
                    int tempA = doubleArr[i][j];
                    int tempB = doubleArr[j][i];

                    // 같을때는 선물 지수 비교
                    if (tempA == tempB) {
                        // 선물 지수 비교
                        int A = presentMap.get(friends[i]);
                        int B = presentMap.get(friends[j]);

                        if (A == B) {
                            // 선물 지수까지 같으면 아무것도 안함
                            continue;
                        } else if (A > B) {
                            winMap.put(friends[i], winMap.getOrDefault(friends[i], 0) + 1);
                        } else {
                            winMap.put(friends[j], winMap.getOrDefault(friends[j], 0) + 1);
                        }
                    }

                    // 개개인 비교
                    else if (tempA > tempB) {
                        winMap.put(friends[i], winMap.getOrDefault(friends[i], 0) + 1);
                    } else {
                        winMap.put(friends[j], winMap.getOrDefault(friends[j], 0) + 1);
                    }
                }
            }
        }

//        System.out.println("최종 다음달 선물 받는 것" + winMap);

        for (int point : winMap.values()) {
            if (max < point) {
                max = point;
            }
        }


        return max / 2;
    }

}
