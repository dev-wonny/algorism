package main.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://school.programmers.co.kr/learn/courses/30/lessons/42579
/*
속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록
 */
public class 베스트앨범 {
    public static void main(String[] args) {
        //[4, 1, 3, 0]
        System.out.println(
            new 베스트앨범().solution(
                new String[] {"classic", "pop", "classic", "classic", "pop"}
                , new int[] {500, 600, 150, 800, 2500}));//4,1,3,0

    }

    class Song {
        int index;
        int play;   // 재생량

        public Song(int index, int play) {  // 생성자
            this.index = index; // 인덱스
            this.play = play;   // 재생량
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 인덱스, 앨범 재생량
        Map<String, Integer> genrePlayTotalCountMap = new HashMap<>();
        Map<String, PriorityQueue<Song>> generQueueMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String key = genres[i];

            // 장르별 재생횟수 list 저장하기
            if (!generQueueMap.containsKey(key)) {
                PriorityQueue<Song> queue = new PriorityQueue<>((a, b) -> a.play == b.play ? a.index - b.index : b.play - a.play);
                queue.add(new Song(i, plays[i]));
                generQueueMap.put(key, queue); // ✅ 꼭 넣어줘야 함

            } else {
                PriorityQueue<Song> queue = generQueueMap.get(key);
                queue.add(new Song(i, plays[i]));
            }

            // 장르별, 합 구하기
            //값 없으면 처음값 넣기
            if (!genrePlayTotalCountMap.containsKey(key)) {
                genrePlayTotalCountMap.put(key, plays[i]);
            }
            // 이미 넣은 값 있으면 추가
            else {
                genrePlayTotalCountMap.put(key, genrePlayTotalCountMap.get(key) + plays[i]);
            }
        }

        //장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        // 3. 장르 정렬 (총 재생 수 기준)
        List<String> sortedGenres = new ArrayList<>(genrePlayTotalCountMap.keySet());
        sortedGenres.sort((a, b) -> genrePlayTotalCountMap.get(b) - genrePlayTotalCountMap.get(a));

        // 4. 장르별 최대 2곡까지 뽑기
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            PriorityQueue<Song> queue = generQueueMap.get(genre);
            int cnt = 0;
            while (!queue.isEmpty() && cnt < 2) {
                result.add(queue.poll().index);
                cnt++;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
