import java.util.Arrays;

/**
 * 배열
 * 순서 있음
 * 중복 허용
 * 크기 고정
 */
public class ArrayMain1 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;

        System.out.println(Arrays.toString(arr));


        // 조회 O(1)
        System.out.println("조회: " + arr[1]);

        int count = 0;

        // 검색 O(N)
        for (int a : arr) {

            ++count;
            if (a == arr.length) {
                System.out.println("검색 >> " + count);
            }
        }

        addFirst(arr, 10);
        System.out.println("맨 앞 추가>> " + Arrays.toString(arr));


        addLast(arr, 11);
        System.out.println("맨 뒤 추가>> " + Arrays.toString(arr));

        addAtIndex(arr, 3, 12);
        System.out.println("중간 추가>> " + Arrays.toString(arr));


    }

    private static void addLast(int[] arr, int newValue) {
        arr[arr.length - 1] = newValue;
    }

    private static void addFirst(int[] arr, int newValue) {
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = newValue;
    }

    private static void addAtIndex(int[] arr, int index, int newValue) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = newValue;
    }


}
