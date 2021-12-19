package com.jeffrey.leetcode.medium;

public class DesignAddAndSearchWords {
	
	/*
	 * Problem: 211. Design Add and Search Words Data Structure
	 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
	 *
	 * Time Complexity: O(N), N = the length of the searching word
	 *
	 * Space Complexity: O(L^27), the max length of the words
	 *
	 */
	class WordDictionary {

	    class TrieNode{
	        TrieNode[] list = new TrieNode[27];
	    }
	    
	    TrieNode root;
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        root=new TrieNode();
	    }
	    
	    public void addWord(String word) {
	       
	        TrieNode p = root;
	        for(char c: word.toCharArray()){
	            int index = c - 'a';
	            if(p.list[index]==null){
	                p.list[index] = new TrieNode();
	            }
	            p=p.list[index];
	        }
	        p.list[26]=new TrieNode();
	        
	    }
	     public boolean search(String word) {
	         return search(root,word,0);
	     }
	    
	    public boolean search(TrieNode root, String word, int index) {
	        TrieNode p = root;
	        for(int i=index;i<word.length();i++){
	            char c = word.charAt(i);
	            if(c=='.'){
	                for(int j=0;j<26;j++){
	                    TrieNode n = p.list[j];
	                    if(n!=null && search(n,word,i+1)){
	                        return true;
	                    }
	                }
	                return false;
	            }else if (p.list[c-'a']==null){
	                return false;
	            }
	            p=p.list[c-'a'];
	        }
	        return p.list[26]!=null;
	        
	    }
	}
}
