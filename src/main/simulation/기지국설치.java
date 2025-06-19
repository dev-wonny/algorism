package main.simulation;

//https://school.programmers.co.kr/learn/courses/30/lessons/12979
public class 기지국설치 {
    public static void main(String[] args) {
//        System.out.println(new 기지국설치().solution(11, new int[] {4, 11}, 1));//3
        System.out.println(new 기지국설치().solution(16, new int[] {9}, 2));//3

    }

    public int solution(int n, int[] stations, int w) {
        int[] arr = new int[n];

        //기지국 설치
        for (int s : stations) {
            AddBuilding(arr, s - 1, w, n);
        }//for end

        //최소한으로 기지국 추가로 설치
        System.out.println(arr);//[ 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 ]

        return reculsive(arr, 0, w, n);
    }

    int reculsive(int[] arr, int addCount, int w, int n) {
        //반복
        while (findZero(arr) != -1) {
            // 0위치를 찾는다
            int zeroIndex = findZero(arr);

            //w 범위 안에 있는지 체크
            int temp = zeroIndex + w;

            //택1) arr[temp]==1이라면 현재 위치에 추가
            if (arr[temp] == 1) {
                addCount++;
                AddBuilding(arr, zeroIndex, w, n);
            }

            //택2) arr[temp]==0이라면 w만큼 이동 후 추가
            else if (arr[temp] == 0) {
                addCount++;
                AddBuilding(arr, temp, w, n);
            }
        }//while end

        return addCount;
    }

    int findZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    void AddBuilding(int[] arr, int s, int w, int n) {
        //본인
        arr[s] = 1;
        //주변
        for (int j = 1; j <= w; j++) {
            int leftIndex = s - j;
            if (leftIndex >= 0) {
                arr[leftIndex] = 1;
            }
            int rightIndex = s + j;
            if (rightIndex < n) {
                arr[rightIndex] = 1;
            }
        }
    }
}
