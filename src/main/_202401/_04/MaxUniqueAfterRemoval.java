package main._202401._04;

import java.util.HashMap;
import java.util.Map;

/**
 * 윈도우 함수
 */
public class MaxUniqueAfterRemoval {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 4, 2, 2};
        int R = 3;
        System.out.println("Expected output: 3, " + maxUniqueAfterRemoval(A, R));
    }

    public static int maxUniqueAfterRemoval(int[] A, int R) {
        // Map to track the frequency of elements in the remaining array
        Map<Integer, Integer> frequency = new HashMap<>();
        int n = A.length;

        // Initialize the map with the first n-R elements
        for (int i = R; i < n; i++) {
            frequency.put(A[i], frequency.getOrDefault(A[i], 0) + 1);
        }

        // Calculate the initial unique count
        int maxUnique = frequency.size();

        // Sliding window to check other possible R-length removals
        for (int i = R; i < n; i++) {
            // Add the element at the start of the sliding window
            int addElement = A[i - R];
            frequency.put(addElement, frequency.getOrDefault(addElement, 0) + 1);

            // Remove the element at the end of the sliding window
            int removeElement = A[i];
            frequency.put(removeElement, frequency.get(removeElement) - 1);

            // If frequency becomes zero, remove it from the map
            if (frequency.get(removeElement) == 0) {
                frequency.remove(removeElement);
            }

            // Update the maximum unique count
            maxUnique = Math.max(maxUnique, frequency.size());
        }

        return maxUnique;
    }

}
