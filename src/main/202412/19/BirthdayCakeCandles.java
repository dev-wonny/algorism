import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true
 */
public class BirthdayCakeCandles {

    public static void main(String[] args) {
        System.out.println("결과: " + birthdayCakeCandles(List.of(3, 2, 1, 3)));
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        Node maxNode = new Node();
        for (int i = 0; i < candles.size(); i++) {
            if (maxNode.key < candles.get(i)) {
                maxNode.changeMax(candles.get(i), i);
            } else if (maxNode.key.equals(candles.get(i))) {
                maxNode.addIndex(i);
            }
        }
        return maxNode.indexList.size();
    }//func end

    public static int birthdayCakeCandles2(List<Integer> candles) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int c : candles) {
            if (c > max) {
                max = c;
                count = 1;
            } else if (c == max) {
                count++;
            }
        }// for end
        return count;
    }

    static class Node {
        Integer key = 0;
        List<Integer> indexList = new ArrayList<>();

        Node() {
            this.key = 0;
            this.indexList.add(0);
        }

        Node(Integer key, Integer index) {
            this.key = key;
            this.indexList.add(index);
        }

        public void changeMax(Integer key, Integer index) {
            this.key = key;
            // this.indexList = new ArrayList<>(List.of(index));
            this.indexList = new ArrayList<>(Arrays.asList(index));
        }

        public void addIndex(Integer index) {
            this.indexList.add(index);
        }
    }// node end
}
