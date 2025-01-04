package main._202401._03;

import java.util.ArrayList;
import java.util.List;

public class SeriesOfLetters2 {

    public static void main(String[] args) {

        System.out.println("expect:AC ,result:" + solution("ACCAABBC"));
        System.out.println("expect: ,result:" + solution("ABCBBCBA"));
        System.out.println("expect:BABABA ,result:" + solution("BABABA"));
    }

    public static String solution(String S) {

        // 한번이라도 연속된 글자가 있어야함


        String[] splitArr = S.split("");
        List<String> newStringArr = makeNewStringArr(splitArr);


        //순환된 데이터가 없으면 그대로 리턴

        return newStringArr.toString();
        // Implement your solution here
    }


    private static List<String> makeNewStringArr(String[] splitArr) {
        // 인접 삭제
        // 새로운 String 배열 생성

        String prevString = splitArr[0];
        int startIndex = 0;
        int sameIndex = 0;
        boolean isDuplicate = false; // 중복 여부 체크


        List<String> newList = new ArrayList<>();


        for (int i = 1; i < splitArr.length; i++) {
            // 처음 일치한다 그러면 인덱스를 늘린다
            if (!isDuplicate && prevString.equals(splitArr[i])) {
                startIndex = (i == 1) ? 0 : i;
                sameIndex = i++;
                continue;
            }

            // 일치한게 유지된다
            else if (prevString.equals(splitArr[i]) && isDuplicate) {
                sameIndex = i++;
                continue;
            }

            //일치했다가 이제는 일치하지 않는다.
            else if (!(prevString.equals(splitArr[i])) && isDuplicate) {
                newList.add(splitArr[i]);
                isDuplicate = false;
            }

            //일치하는 글자가 안나타남 다음 글자로 이동
            else {
                prevString = splitArr[i];
                newList.add(splitArr[i]);
                i++;
            }

        }// for end

        return newList;
    }
}
