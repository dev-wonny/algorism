package main.집합;

//https://school.programmers.co.kr/learn/courses/30/lessons/12938
public class 최고의집합 {

    public static void main(String[] args) {
        System.out.println(new 최고의집합().solution(2, 1));//[-1]
        System.out.println(new 최고의집합().solution(2, 8));//[4,4]//{ 1, 7 }, { 2, 6 }, { 3, 5 }, { 4, 4 }
        System.out.println(new 최고의집합().solution(2, 9));//[4,5]//{ 1, 8 }, { 2, 7 }, { 3, 6 }, { 4, 5 }

        System.out.println(new 최고의집합().solution(3, 9));//[3,3,3] 나머지0
        System.out.println(new 최고의집합().solution(3, 10));//[3,3,4] 나머지1
        System.out.println(new 최고의집합().solution(3, 11));//[3,4,4] 나머지2
        System.out.println(new 최고의집합().solution(3, 12));//[4,4,4] 나머지0

        System.out.println(new 최고의집합().solution(4, 15));//[3,4,4,4] 나머지3
    }

    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[] {-1};
        }

        int size = n;
        int[] answer = new int[size];
        int base = s / size;
        int mod = s % size;

        for (int i = 0; i < size; i++) {
            answer[i] = base;
        }

        // 뒤에서부터 mod개만 1씩 증가
        for (int i = n - 1; i >= n - mod; i--) {
            answer[i]++;
        }

        return answer;
    }
}
