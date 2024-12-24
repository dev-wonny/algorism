import java.util.List;

/**
 * https://www.hackerrank.com/challenges/mini-max-sum/problem?isFullScreen=true
 */
public class MiniMaxSum {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(256741038, 623958417, 467905213, 714532089, 938071625);
        MiniMaxSum.miniMaxSum(list2);

    }

    public static void miniMaxSum(List<Integer> arr) {
        long sum = 0;
        long max = 0;
        long min = arr.get(0);

        for (long a : arr) {
            sum += a;
            max = Math.max(a, max);
            min = Math.min(a, min);
        }// for end

        System.out.println((sum - max) + " " + (sum - min));

    }// end
}
