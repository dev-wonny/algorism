package main.조합;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

//https://school.programmers.co.kr/learn/courses/30/lessons/64064
public class 불량사용자 {

    public static void main(String[] args) {
        System.out.println(new 불량사용자().solution(
            new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}
            , new String[] {"fr*d*", "abc1**"}
        ));//2

        // "*rodo", "*rodo" 중복됨 -> 2*2 됨
        System.out.println(new 불량사용자().solution(
            new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}
            , new String[] {"*rodo", "*rodo", "******"}
        ));//2

        System.out.println(new 불량사용자().solution(
            new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}
            , new String[] {"fr*d*", "*rodo", "******", "******"}
        ));//3

    }


    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> candidateList = new ArrayList<>();//불량 아이디에 매칭되는 아이디를 각각 담고 있음

        // 각 불량 사용자 ID에 매칭되는 사용자 ID 목록 생성
        for (int i = 0; i < banned_id.length; i++) {

            //초기화
            List<String> matchedList = new ArrayList<>();
            for (int j = 0; j < user_id.length; j++) {
                String ban = banned_id[i].replace("*", ".");
                String user = user_id[j];

                // Pattern.matches 사용 regex, input
                if (ban.length() == user.length() && Pattern.matches(ban, user)) {
                    matchedList.add(user);
                }
            }// for end
            candidateList.add(matchedList);
        }


        Set<String> result = new HashSet<>();
        // DFS를 통한 조합 탐색
        dfs(0, new TreeSet<>(), result, candidateList);
        return result.size();
    }

    private void dfs(int depth, TreeSet<String> path, Set<String> result, List<List<String>> candidateList) {
        // 완성, 조합된 사용자 ID 목록을 정렬하여 문자열로 변환 후 Set에 추가
        if (depth == candidateList.size()) {
            result.add(path.toString());
            return;
        }

        // 계속 추가, 조합 생성, backtracking
        List<String> list = candidateList.get(depth);
        for (String user : list) {
            if (path.contains(user)) {
                continue;
            }
            path.add(user);
            dfs(depth + 1, path, result, candidateList);
            path.remove(user);
        }
    }

    // 매칭 개수 곱해서 리턴
    public int solution2(String[] user_id, String[] banned_id) {
        int answer = 1;

        //브루트포스
        Arrays.sort(user_id);
        Arrays.sort(banned_id);

        List<Integer> modList = new ArrayList<>();

        //banned_id 중복 제거
        Set<String> bannedSet = new HashSet<>();
        int mod = 1;
        for (int i = 0; i <= banned_id.length; i++) {
            if (i == banned_id.length) {
                modList.add(mod);
                break;
            }
            if (bannedSet.add(banned_id[i])) {
                modList.add(mod);
                mod = 1;
            }
            // 이미 존재
            else {
                mod++;
            }
        }

        for (String s : bannedSet) {
            String[] splitedBannedId = s.split("");

            // 불량사용자에 일치되는 -> 사용자 아이디 개수 구하기
            int tempCount = 0;
            for (int j = 0; j < user_id.length; j++) {
                String[] splitedUserId = user_id[j].split("");

                // 글자수 안 같으면 건너뜀
                if (splitedUserId.length != splitedBannedId.length) {
                    continue;
                }

                // 글자 개수가 같은 경우 검증
                for (int k = 0; k <= splitedUserId.length; k++) {
                    // 마지막 도달시 카운트 증가
                    if (k == splitedUserId.length) {
                        tempCount++;
                        break;
                    }
                    if (splitedBannedId[k].equals("*")) {
                        continue;
                    }
                    if (!splitedUserId[k].equals(splitedBannedId[k])) {
                        break;
                    }
                }// 글자 검수 for end

            }// 불량 아이디 일치하는지 검색 end
            if (tempCount == 0) {
                continue;
            }
            // 블랙리스트에 해당하는 곱
            answer *= tempCount;

        }// 아이디 순회 for end

        for (int i = 0; i < modList.size(); i++) {
            answer /= modList.get(i);
        }


        return answer;
    }

    // 3번 때문에 2*2 가 아니라 1*1 + 1*2 =  3
    // 즉 값 넣고 경우의 수를 세는게 나음

    public int solution1(String[] user_id, String[] banned_id) {
        //배열에 배열에 배열로 매칭할거임
        for (int i = 0; i < user_id.length; i++) {
            String[] split = user_id[i].split("");

        }
        for (int i = 0; i < banned_id.length; i++) {

        }
        int answer = 0;
        return answer;
    }
}
