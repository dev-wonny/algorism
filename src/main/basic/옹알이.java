package main.basic;

import java.util.regex.Pattern;

public class 옹알이 {
    public static void main(String[] args) {
        System.out.println(new 옹알이().solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));//1
        System.out.println(new 옹알이().solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}));//3
        System.out.println(new 옹알이().solution(new String[]{"yeyeayaayawoo", "mawoowoo", "yawoo"}));//2
    }

    public int solution(String[] babbling) {
        int result = 0;
        for (int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("aya", "1");
            babbling[i] = babbling[i].replace("ye", "1");
            babbling[i] = babbling[i].replace("woo", "1");
            babbling[i] = babbling[i].replace("ma", "1");
            // 단어 붙는거 막으려고 1 넣음
            babbling[i] = babbling[i].replace("1", "");
            if (babbling[i].isBlank()) {
                result++;
            }
        }
        return result;
    }

    public int solution1(String[] babbling) {
        String[] rootList = {"aya", "ye", "woo", "ma"};
        int matchedCount = 0;
        // 탐색할 단어 : 5개, 글자 하나씩 조지기
        for (String targerWord : babbling) {
            int targetWordIdx = 0;

            // target의 한 단어에서 4개의 고정 단어를 계속해서 지워간다
            while (targetWordIdx < targerWord.length()) {
                boolean matched = false;// 계속해서 초기화
                // 매칭할 단어 : 고정 4개
                for (String root : rootList) {
                    // 시작 단어가 같다면 탐색의 시작, 계속해서 단어를 지워나가는 작업을 한다
                    if (targerWord.startsWith(root, targetWordIdx)) {
                        targetWordIdx += root.length();
                        matched = true;
                        break;// 매칭 단어 for 문 벗어남 -> while로 가서 -> aya 찾고 또 aya 찾음
                    }
                }// root for end
                // while문 벗어날 수 있는 point, 더이상 매칭될게 없음
                if (!matched) {
                    break;
                }
            }// while end

            // while문에서 최대한 글자를 지우고 난뒤 길이가 0이 되었다면 완전 일치된거라 숫자 증가시킴
            if (targetWordIdx == targerWord.length()) {
                matchedCount++;
            }
        }// babbling for end
        return matchedCount;
    }

    public int solution2(String[] babbling) {
        Pattern p = Pattern.compile("^(aya|ye|woo|ma)+$");
        int count = 0;
        for (String w : babbling) {
            if (p.matcher(w).matches()) {
                count++;
            }
        }// for end
        return count;
    }
}
