package collection.set.javaset;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 집합 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));

        Set<Integer> 합집합 = new HashSet<>(set1);
        합집합.addAll(set2);

        Set<Integer> 교집합 = new HashSet<>(set1);
        교집합.retainAll(set2);

        Set<Integer> 차집합 = new HashSet<>(set1);
        차집합.removeAll(set2);

        System.out.println("합집합: " + 합집합);
        System.out.println("교집합: " + 교집합);
        System.out.println("차집합: " + 차집합);
    }
}
