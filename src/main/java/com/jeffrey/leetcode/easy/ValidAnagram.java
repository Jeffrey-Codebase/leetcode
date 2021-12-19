package com.jeffrey.leetcode.easy;

public class ValidAnagram {

	
	/*
	 * Problem: 242. Valid Anagram
	 * https://leetcode.com/problems/valid-anagram/
	 *
	 * Time Complexity: O(M+N), M = the length of s string,
	 * N = the length of the t string
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public boolean isAnagram(String s, String t) {
        int[] sc = new int[26];
        int[] tc = new int[26];
        for(char c : s.toCharArray()){
            sc[c-'a']++;
        }
        for(char c : t.toCharArray()){
            tc[c-'a']++;
        }
        for(int i=0; i<26; i++){
            if(sc[i]!=tc[i])
                return false;
        }
        return true;
    }
}
