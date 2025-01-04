package main._202401._04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountPalindromicSubsequence2 {
    public static void main(String[] args) {
        System.out.println("Expected output: 3, " + countPalindromicSubsequence("aabca"));
        System.out.println("Expected output: 0, " + countPalindromicSubsequence("adc"));
        System.out.println("Expected output: 4, " + countPalindromicSubsequence("bbcbaba"));
    }

    public static int countPalindromicSubsequence(String s) {
        Map<Character, Integer[]> charIndicesMap = new HashMap<>();

        // Populate the map with the first and last indices of each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charIndicesMap.containsKey(c)) {
                charIndicesMap.put(c, new Integer[] {i, i}); // Initialize first and last index
            } else {
                charIndicesMap.get(c)[1] = i; // Update the last index
            }
        }

        int count = 0;

        // Check each character's first and last indices to find valid palindromic subsequences
        for (Map.Entry<Character, Integer[]> entry : charIndicesMap.entrySet()) {
            int firstIndex = entry.getValue()[0];
            int lastIndex = entry.getValue()[1];

            // If the character appears more than once
            if (lastIndex - firstIndex > 1) {
                Set<Character> uniqueChars = new HashSet<>();

                // Collect all unique characters between the first and last occurrence
                for (int i = firstIndex + 1; i < lastIndex; i++) {
                    uniqueChars.add(s.charAt(i));
                }

                // Add the count of unique characters to the result
                count += uniqueChars.size();
            }
        }

        return count;

    }
}
