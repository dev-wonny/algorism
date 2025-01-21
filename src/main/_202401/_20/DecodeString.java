package main._202401._20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//https://leetcode.com/problems/decode-string
public class DecodeString {
    public static void main(String[] args) {
        System.out.println("3[a]2[bc] -> expect: aaabcbc, result:" + decodeString("3[a]2[bc]"));
        System.out.println("3[a2[c]] -> expect: accaccacc, result:" + decodeString("3[a2[c]]"));
        System.out.println("2[abc]3[cd]ef-> expect: abcabccdcdcdef, result:" + decodeString("2[abc]3[cd]ef"));
    }

    public static String decodeString(String s) {
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        StringBuilder numb = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                numb.append(c);
            } else if (c == '[') {
                numStack.push(Integer.parseInt(numb.toString()));
                numb.setLength(0);//초기화

                strStack.push(sb);
                sb = new StringBuilder();//초기화
            } else if (c == ']') {
                int repeat = numStack.pop();
                StringBuilder temp = sb;
                sb = strStack.pop();
                for (int i = 0; i < repeat; i++) {
                    sb.append(temp);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String decodeString4(String s) {
        Deque<String> stringStack = new ArrayDeque<>();
        Deque<Integer> countStack = new ArrayDeque<>();

        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        for (char c : s.toCharArray()) {
            // 숫자인 경우 숫자를 계산 (여러 자리 처리)
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0');
            }
            // 여는 괄호: 현재 상태를 스택에 저장
            else if (c == '[') {
                countStack.push(currentNum); // 반복 횟수 저장
                stringStack.push(currentString.toString()); // 현재 문자열 저장
                currentNum = 0; // 숫자 초기화
                currentString = new StringBuilder(); // 새 문자열 시작
            }
            // 닫는 괄호: 반복된 문자열 처리
            else if (c == ']') {
                int repeatCount = countStack.pop(); // 반복 횟수
                StringBuilder temp = new StringBuilder(stringStack.pop()); // 이전 문자열
                for (int i = 0; i < repeatCount; i++) {
                    temp.append(currentString); // 반복 추가
                }
                currentString = temp; // 결과를 현재 문자열로 설정
            }
            // 일반 문자 처리
            else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
    
    public static String decodeString3(String s) {
        char[] charArray = s.toCharArray();

        Deque<Character> charStack = new ArrayDeque<>();

        StringBuilder result = new StringBuilder();


        for (int i = 0; i < charArray.length; i++) {
            // 넣고 시작
            charStack.push(charArray[i]);

            while (!charStack.isEmpty()) {
                // 넣은거 확인
                char pop = charStack.pop();

                // 숫자,[,*,] 4개를 한번에 없애기
                if (pop == ']') {
                    LinkedList<String> tempList = new LinkedList();

                    // [가 나올때까지 stringStack pop해
                    while (!charStack.isEmpty()) {
                        char pop2 = charStack.pop();// pop

                        // 알파벳은 문자 합치기
                        if (Character.isAlphabetic(pop2)) {
                            // 앞에 붙이기
                            tempList.addFirst(java.lang.String.valueOf(pop2));
                        }

                        // 앞 숫자 반복해서 result에 넣기
                        else if (pop2 == '[') {
                            // 앞에 숫자를 charStack pop

                            //숫자가 한 자리 이상인 경우(예: 12[a]) 제대로 처리되지 않습니다.
                            int popNum = charStack.pop() - '0';//pop

                            // 글자를 곱해, 결과 추가
                            for (int j = 0; j < popNum; j++) {
                                //중첩된 결과를 처리하지 않고, 바로 최종 결과에 추가하려고 합니
                                result.append(java.lang.String.join("", tempList));
                            }// for end
                        }
                    }// while isStartString end
                }// if ] end

                // 해당하는게 없음, 다시 넣음
                else {
                    charStack.push(pop);
                    break;
                }

            }// !charStack.isEmpty() while end
        }// for end
        return result.toString();
    }// func end

    public static String decodeString2(String s) {
        char[] charArray = s.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        boolean isStartString = false;


        for (int i = 0; i < charArray.length; i++) {
            stack.push(charArray[i]);

            while (!stack.isEmpty()) {

                Character pop = stack.pop();

                // 숫자
                if (Character.isDigit(pop)) {
                    stack.add(pop);
                }
                // 문자
                else {

                    // 문자 누적
                    if (isStartString) {
                        sb.append(pop);
                    }

                    //문자 시작
                    else if (pop - '0' == 91) {
                        isStartString = true;
                    }

                    // 문자 끝
                    else if (pop - '0' == 92) {
                        isStartString = false;
                        int popNum = stack.pop();//숫자
                        for (i = 0; i < popNum; i++) {
                            result.append(sb);
                        }
                        sb = new StringBuilder();//초기화
                    }
                }// 문자 else end
            }// while end
        }// for end
        return result.toString();
    }// func end
}
