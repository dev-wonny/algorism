package main._202503;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageCleaner {
    public static void main(String[] args) {
        List<String> messages = List.of(
            "I love you 😍😍!",
            "LOVE is all you need ❤️.",
            "You are amazing!!! 😊"
        );

        Map<String, Integer> result = cleanAndCountWords(messages);
        result.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    public static Map<String, Integer> cleanAndCountWords(List<String> messages) {
        Map<String, Integer> wordCount = new HashMap<>();
        Pattern wordPattern = Pattern.compile("[a-zA-Z]+"); // 영문자 단어만 추출

        for (String message : messages) {
            // 1. 이모지 및 특수문자 제거 (문자열에서 영문만 추출)
            Matcher matcher = wordPattern.matcher(message);

            while (matcher.find()) {
                String word = matcher.group().toLowerCase(); // 소문자로 변환
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        return wordCount;
    }
}
