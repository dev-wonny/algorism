package main._202503;

//https://leetcode.com/problems/implement-trie-prefix-tree
public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");//return True
        trie.search("app");//return False
        trie.startsWith("app"); //return True
        trie.insert("app");
        trie.search("app");// return True
    }

    private class TrieNode {
        boolean isEnd;
        TrieNode[] children; // 알파벳 배열을 직접 TrieNode 배열로 변경

        public TrieNode() {
            this.isEnd = false;
            this.children = new TrieNode[26]; // a-z까지 26개의 자식 노드 관리
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curNode = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curNode.children[index] == null) {
                curNode.children[index] = new TrieNode();
            }
            curNode = curNode.children[index];
        }
        curNode.isEnd = true;
    }

    public boolean search(String word) {
        return searchRecursive(word, 0, root);
    }

    private boolean searchRecursive(String word, int dept, TrieNode node) {
        if (node == null) {
            return false;
        }

        // break point
        if (dept == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(dept);
        int index = ch - 'a';

        // 검색 로직, 모든 경우 탐색
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (searchRecursive(word, dept + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        }//if end
        else {
            //특정 문자 탐색
            if (node.children[index] == null) {
                return false;
            }
            return searchRecursive(word, dept + 1, node.children[index]);
        }//else end
    }//end searchRecursive

    public boolean startsWith(String prefix) {
        return searchRecursive2(prefix, 0, root);
    }

    private boolean searchRecursive2(String word, int dept, TrieNode node) {
        if (node == null) {
            return false;
        }

        // break point
        if (dept == word.length()) {
            return true;
        }

        char ch = word.charAt(dept);
        int index = ch - 'a';

        // 검색 로직, 모든 경우 탐색
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (searchRecursive2(word, dept + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        }//if end
        else {
            //특정 문자 탐색
            if (node.children[index] == null) {
                return false;
            }

            return searchRecursive2(word, dept + 1, node.children[index]);
        }//else end
    }//end searchRecursive
}
