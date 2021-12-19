package com.jeffrey.leetcode.medium;

public class ImplementTrie {
	
	/*
	 * Problem: 208. Implement Trie
	 * https://leetcode.com/problems/implement-trie-prefix-tree/
	 *
	 * Time Complexity: O(N), N = the length of the string
	 *
	 * Space Complexity: O(L^27), L = the max length of the inserted string
	 *
	 */
	class Trie {
	    private Trie[] child;
	    public Trie() {
	        child = new Trie[27];
	    }
	    
	    public void insert(String word) {
	        Trie p = this;
	        for(char c : word.toCharArray()){
	            int idx = c-'a';
	            if(p.child[idx]==null)
	                p.child[idx] = new Trie();
	            p = p.child[idx];
	        }
	        p.child[26] = new Trie();
	    }
	    
	    private Trie get(String word){
	        Trie p = this;
	        for(char c : word.toCharArray()){
	            int idx = c-'a';
	            if(p.child[idx]==null)
	               return null;
	            p = p.child[idx];
	        }
	        return p;
	    }
	    
	    public boolean search(String word) {
	        Trie t = get(word);
	        return t!=null && t.child[26]!=null;
	    }
	    
	    public boolean startsWith(String prefix) {
	        Trie t = get(prefix);
	        return t!=null;
	    }
	}


}
