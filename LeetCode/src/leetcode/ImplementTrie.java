package leetcode;

public class ImplementTrie {
    /**
     * 208. Implement Trie (Prefix Tree)
     * https://leetcode.com/problems/implement-trie-prefix-tree/
     */
    class Trie {
        private class Node {
            Node[] childs = new Node[26];
            boolean isLeaf;
        }

        private Node root = new Node();

        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            insert(word, root);
        }

        private void insert(String word, Node node) {
            if (node == null) {
                return;
            }
            if (word.length() == 0) {
                node.isLeaf = true;
                return;
            }
            int index = indexForChar(word.charAt(0));
            if (node.childs[index] == null) {
                node.childs[index] = new Node();
            }
            insert(word.substring(1), node.childs[index]);
        }

        private int indexForChar(char c) {
            return c - 'a';
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return search(word, root);
        }

        private boolean search(String word, Node node) {
            if (node == null) {
                return false;
            }
            if (word.length() == 0) {
                return node.isLeaf;
            }
            int index = indexForChar(word.charAt(0));
            return search(word.substring(1),node.childs[index]);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return startsWith(prefix, root);
        }

        private boolean startsWith(String prefix, Node node) {
            if (node == null) {
                return false;
            }
            if (prefix.length() == 0) {
                return true;
            }
            int index = indexForChar(prefix.charAt(0));
            return startsWith(prefix.substring(1), node.childs[index]);
        }
    }

}
