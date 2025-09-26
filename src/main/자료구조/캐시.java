package main.자료구조;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class 캐시 {

    public static void main(String[] args) {
//        System.out.println(
//            "expect: 50, result: " + new 캐시().solution(3, new String[] {
//                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
//            }));
//
//        System.out.println(
//            "expect: 21, result: " + new 캐시().solution(3, new String[] {
//                "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"
//            }));
//
//        System.out.println(
//            "expect: 60, result: " + new 캐시().solution(2, new String[] {
//                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
//            }));
//
//        System.out.println(
//            "expect: 16, result: " + new 캐시().solution(2, new String[] {
//                "Jeju", "Pangyo", "NewYork", "newyork"
//            }));
//
//        System.out.println(
//            "expect: 52, result: " + new 캐시().solution(5, new String[] {
//                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
//            }));
//
//        System.out.println(
//            "expect: 25, result: " + new 캐시().solution(0, new String[] {
//                "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
//            }));

        //hit일 때도 기존 값의 위치를 갱신해야 하는데, 이 로직이 없음.

        // 중복 데이터

        System.out.println(
            "expect: 7, result: " + new 캐시().solution(3, new String[] {
                "Seoul", "Seoul", "Seoul"
            }));
    }

    public int solution(int cacheSize, String[] cities) {
        final int hitTime = 1;
        final int missTime = 5;
        if (cacheSize <= 0) {
            return cities.length * missTime;
        }

        int sumTotalTime = 0;
        //캐시 사이즈로 Linked list 생성, 빠른 검색을 위한 HashSet 사용
        //HashSet, Linked list -> 빠른 검색 && 순서 제거(빠른 앞 제거, 길이 체크)
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        // cities를 순회하면서 set에 넣는다.
        for (int i = 0; i < cities.length; i++) {
            final String currentKey = cities[i].toLowerCase();

            // list 사이즈가 작으면 걍 set 추가, list 추가, 누적시간 추가
            if (list.size() < cacheSize) {
                // 여기서도 중복데이터가 추가 될 수 있음

                //      Hit: 검색에서 찾으면 -> 누적 시간만 추가 + 최신 땡기기
                if (set.contains(currentKey)) {
                    hitCache(currentKey, list);
                    sumTotalTime += hitTime;
                }
                //      Miss: 검색에서 없으면 ->  맨 뒤에 새로운 단어 추가, set추가, 누적 시간 추가
                else {
                    addKeyword(currentKey, list, set);
                    sumTotalTime += missTime;
                }

            }

            // list 사이즈가 이미 찼으면 검색 후 추가
            else {
                //      Hit: 검색에서 찾으면 -> 누적 시간만 추가 + 최신 땡기기
                if (set.contains(currentKey)) {
                    hitCache(currentKey, list);
                    sumTotalTime += hitTime;
                }
                //      Miss: 검색에서 없으면 -> linked listd에서 맨 앞 제거, 맨 뒤에 새로운 단어 추가, set추가, 누적 시간 추가
                else {
                    removeFirstKeyword(list, set);
                    addKeyword(currentKey, list, set);

                    sumTotalTime += missTime;
                }
            }

        }
        return sumTotalTime;
    }

    private void addKeyword(String keyword, List<String> list, Set<String> set) {
        list.add(keyword);
        set.add(keyword);
    }

    private void removeFirstKeyword(List<String> list, Set<String> set) {
        String remove = list.remove(0);
        set.remove(remove);
    }

    private void hitCache(String keyword, List<String> list) {
        list.remove(keyword);
        list.add(keyword);
    }

    private int soultion2(int cacheSize, String[] cities) {
        final int HIT = 1, MISS = 5;
        if (cities == null || cities.length == 0) {
            return 0;
        }
        if (cacheSize <= 0) {
            return cities.length * MISS;
        }

        Map<String, Boolean> lru = new LinkedHashMap<String, Boolean>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
                return size() > cacheSize;
            }
        };

        int time = 0;
        for (String city : cities) {
            final String keyword = city.toLowerCase(Locale.ROOT);

            if (lru.containsKey(keyword)) {
                time += HIT;
                lru.get(keyword);// access → 최근으로 이동 (accessOrder=true)
            } else {
                time += MISS;
                lru.put(keyword, true);// 초과 시 가장 오래된 항목 자동 제거 -> removeEldestEntry
            }
        }

        return time;
    }

}
