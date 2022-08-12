package Leetcode.Tries;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}

class Trie {
    Map<Character, Trie> children;
    boolean isWord;
    char val;
    public Trie() {
        children = new HashMap<>();
    }
    
    public void insert(String word) {
        Trie t = new Trie();
        Map<Character, Trie> pointer = children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (pointer.get(c) == null) {
                pointer.put(c, new Trie());
            }
            t = pointer.get(c);
            pointer = t.children;
        }
        t.isWord = true;
    }
    
    public boolean search(String word) {
        Map<Character, Trie> pointer = children;
        Trie t = new Trie();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (pointer.get(c) == null) {
                return false;
            }
            t = pointer.get(c);
            pointer = t.children;
        }
        return t.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Map<Character, Trie> pointer = children;
        Trie t = new Trie();
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (pointer.get(c) == null) {
                return false;
            }
            t = pointer.get(c);
            pointer = t.children;
        }
        return true;   
    }
}