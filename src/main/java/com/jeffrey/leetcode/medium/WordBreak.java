package com.jeffrey.leetcode.medium;

import java.util.List;

public class WordBreak {
	
	/*
	 * Problem: 139. Word Break
	 * https://leetcode.com/problems/word-break/
	 *
	 * Time Complexity: O(max(M,N)), M = the length of the s string, 
	 * N = the length of the wordDict list
	 *
	 * Space Complexity: O(max(L^27,M)), L = the max length of the word in the wordDict
	 *
	 */
	class TrieNode{
        TrieNode[] child = new TrieNode[27];
    }
    private TrieNode root;
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        dp = new Boolean[s.length()];
        boolean[] letter = new boolean[26];
        for(String w : wordDict){
            TrieNode p = root;
            for(char c : w.toCharArray()){
                int idx = c-'a';
                letter[idx]=true;
                if(p.child[idx]==null)
                    p.child[idx] = new TrieNode();
                p = p.child[idx];
            }
            p.child[26] = new TrieNode();
        }
        for(char c : s.toCharArray()){
            if(!letter[c-'a'])
                return false;
        }
        return helper(s,0);
    }
    
    private boolean helper(String s, int sidx){
        if(sidx==s.length())
            return true;
        if(dp[sidx]!=null)
            return dp[sidx];
        TrieNode p = root;
        while(sidx<s.length()){
            if(p.child[26]!=null && helper(s,sidx)){
                dp[sidx]=true;
                return true;
            }    
            int idx = s.charAt(sidx)-'a';
            if(p.child[idx]==null)
                break;
            p=p.child[idx];
            sidx++;
        }
        if(sidx==s.length())
            return p.child[26]!=null;
        dp[sidx] = false;
        return false;
        
    }

}
