public class TablePrinterWithIndex {
    public static void printAsTableWithIndex(int[][] array) {
        // 열 인덱스 출력
        int colCount = array[0].length;
        System.out.print("Y   "); // 빈 공간
        for (int col = 0; col < colCount; col++) {
            System.out.printf("%4d", col);
        }
        System.out.println();
        System.out.println("---".repeat(colCount + 1));

        // 행 출력
        for (int row = 0; row < array.length; row++) {
            System.out.printf("%4d", row); // 행 인덱스
            for (int value : array[row]) {
                System.out.printf("%4d", value);
            }
            System.out.println(); // 행 끝에서 줄바꿈
        }
    }

    public static void main(String[] args) {
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12}
        };

        printAsTableWithIndex(array);
    }
}
