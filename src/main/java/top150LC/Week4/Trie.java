package org.Week4;

import java.util.HashMap;

class TrieNode{
    HashMap<Character,TrieNode> children= new HashMap<>();
    // You may also use char array if only small case alphabets are used-
    // TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    // By using array-
    //if (curr.children[ch - 'a'] == null) {
    //    curr.children[ch - 'a'] = new TrieNode();
    //}
    //curr = curr.children[ch - 'a'];
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(! curr.children.containsKey(ch)){
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(curr.children.get(ch) == null){
                return false;
            }
            curr = curr.children.get(ch);
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch: prefix.toCharArray()){
            if(curr.children.get(ch) == null){
                return false;
            }
            curr = curr.children.get(ch);
        }
        return true;
    }
}

/**
 * Characters in Java have underlying ASCII values.
 * 'a' is ASCII 97, 'b' is 98, ..., 'z' is 122.
 * So 'c' - 'a' gives:
 * 'c' - 'a' = 99 - 97 = 2
 */