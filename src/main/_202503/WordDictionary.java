package main._202503;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");

        System.out.println(dictionary.search("pad")); // false
        System.out.println(dictionary.search("bad")); // true
        System.out.println(dictionary.search(".ad")); // true
        System.out.println(dictionary.search("b..")); // true

    }

    // words length >=25

    private class TrieNode {
        Map<Character, TrieNode> children;//using Map
        boolean isEnd;

        TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    private final TrieNode root;


    private WordDictionary() {
        root = new TrieNode();
    }

    private void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    private boolean search(String word) {
        return searchRecursive(word, 0, root);
    }

    private boolean searchRecursive(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(index);
        if (ch == '.') {
            // '.' 와일드카드는 모든 가능한 문자 탐색
            for (TrieNode child : node.children.values()) {
                if (searchRecursive(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // 특정 문자 탐색
            return searchRecursive(word, index + 1, node.children.get(ch));
        }
    }
}
