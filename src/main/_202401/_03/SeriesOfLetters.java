package main._202401._03;

import java.util.Arrays;

public class SeriesOfLetters {

    public static void main(String[] args) {

        System.out.println("expect:AC ,result:" + solution("ACCAABBC"));
        System.out.println("expect: ,result:" + solution("ABCBBCBA"));
        System.out.println("expect:BABABA ,result:" + solution("BABABA"));
    }

    public static String solution(String S) {

        // 한번이라도 연속된 글자가 있어야함


        String[] splitArr = S.split("");
        String[] newStringArr = makeNewStringArr(splitArr);


        //순환된 데이터가 없으면 그대로 리턴

        return Arrays.toString(newStringArr);
        // Implement your solution here
    }


    private static String[] makeNewStringArr(String[] splitArr) {
        // 인접 삭제
        // 새로운 String 배열 생성

        String prevString = splitArr[0];
        int startIndex = 0;
        int sameIndex = 0;
        boolean isDuplicate = false; // 중복 여부 체크


        for (int i = 1; i < splitArr.length; i++) {
            // 처음 일치한다 그러면 인덱스를 늘린다
            if (!isDuplicate && prevString.equals(splitArr[i])) {
                startIndex = (i == 1) ? 0 : i;
                sameIndex = i++;
            }

            // 일치한게 유지된다
            else if (isDuplicate && prevString.equals(splitArr[i])) {
                sameIndex = i++;
            }

            //일치했다가 이제는 일치하지 않는다.
            else if (isDuplicate && !(prevString.equals(splitArr[i]))) {

                // 새로운 배열을 만들어서 이 작업은 반복한다
                if (startIndex == 0) {
                    // 처음부터 제거인 경우
                    return makeNewStringArr(Arrays.copyOfRange(splitArr, i, splitArr.length - 1));
                } else if (sameIndex == splitArr.length - 1) {
                    //마지막 제거인경우
                    return makeNewStringArr(Arrays.copyOfRange(splitArr, 0, startIndex));

                } else {
                    //중간부터 제거인 경우
                    // 앞
                    String[] frontStrings = Arrays.copyOfRange(splitArr, 0, startIndex - 1);


                    // 뒤
                    String[] backStrings = Arrays.copyOfRange(splitArr, sameIndex + 1, splitArr.length - 1);

                    String[] mergedStrings = new String[frontStrings.length + backStrings.length];
                    System.arraycopy(frontStrings, 0, mergedStrings, 0, frontStrings.length);
                    System.arraycopy(backStrings, 0, mergedStrings, frontStrings.length, backStrings.length);

                    return makeNewStringArr(mergedStrings);

                }
            }

            //일치하는 글자가 안나타남 다음 글자로 이동
            else {
                prevString = splitArr[i];
            }

        }// for end

        return splitArr;
    }
}
