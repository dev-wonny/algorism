package main._202401._04;

public class LILLYBILLYBOO2 {
    public static void main(String[] args) {
        System.out.println("Expected output: 2, " + maxNames("LILLYBILLYBOO", new String[] {"BILL", "MARIA", "LILLY"}));
    }

    public static int maxNames(String s, String[] names) {
        // S의 문자 빈도 계산
        int[] sCount = new int[26]; // S의 각 문자의 빈도
        for (char c : s.toCharArray()) {
            sCount[c - 'A']++;
        }

        int maxCount = 0;

        for (String name : names) {
            int[] nameCount = new int[26]; // 이름의 각 문자의 빈도
            for (char c : name.toCharArray()) {
                nameCount[c - 'A']++;
            }

            int count = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (nameCount[i] > 0) {
                    count = Math.min(count, sCount[i] / nameCount[i]);// 필요한 문자/필요한 개수
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
