package collection.sort;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

    public static void insertionSort(int[] numArr) {
        // 배열의 두 번째 요소부터 시작 (첫 번째 요소는 이미 정렬되어 있다고 가정)
        for (int choicedIndex = 1; choicedIndex < numArr.length; choicedIndex++) {
            int choicedValue = numArr[choicedIndex];  // 현재 정렬할 값
            int beforeIndex = choicedIndex - 1;    // 현재 위치를 기준으로 왼쪽으로 이동하며 비교

            // 값이 왼쪽의 값보다 작은 경우, 한 칸씩 오른쪽으로 밀어낸다.
            while (beforeIndex >= 0 && choicedValue < numArr[beforeIndex]) {
                numArr[beforeIndex + 1] = numArr[beforeIndex];  // 한 칸씩 오른쪽으로 밀기
                beforeIndex = beforeIndex - 1;  // 왼쪽으로 이동
            }

            // 적절한 위치에 choicedValue 값을 삽입
            numArr[beforeIndex + 1] = choicedValue;
        }
    }

    public static List<Integer> insertionSort(List<Integer> numList) {
        // numList 두 번째 요소부터 시작 (첫 번째 요소는 이미 정렬되어 있다고 가정)
        for (int choicedIndex = 1; choicedIndex < numList.size(); choicedIndex++) {
            int choiceValue = numList.get(choicedIndex);
            int beforeIndex = choicedIndex - 1;

            // choiceValue가 이전 값보다 작은 경우, 한 칸씩 오른쪽으로 밀어낸다.
            while (beforeIndex >= 0 && choiceValue < numList.get(beforeIndex)) {
                numList.set(beforeIndex + 1, numList.get(beforeIndex));
                beforeIndex = beforeIndex - 1;
            }

            /// 적절한 위치에 choicedValue 값을 삽입
            numList.set(beforeIndex + 1, choiceValue);
        }
        return numList;
    }


    public static void main(String[] args) {
        // 예시 배열
        int[] nums = {9, 3, 5, 7, 1};

        // 정렬 호출
        insertionSort(nums);

        // 결과 출력
        System.out.print("Sorted Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }


        List<Integer> sortedNums = insertionSort(new ArrayList<>(List.of(9, 3, 5, 7, 1)));
        System.out.println(sortedNums);
    }
}
