package com.jeffrey.leetcode.medium;

public class PalindromicSubstrings {

	
	/*
	 * Problem: 647. Palindromic Substrings
	 * https://leetcode.com/problems/palindromic-substrings/
	 *
	 * Time Complexity: O(N*N), N = the length of the s string
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int countSubstrings(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++){
            ans += helper(s,i,i);
            ans += helper(s,i,i+1);
        }
        return ans;
    }
    
    private int helper(String s , int left, int right){
        if(left<0 || right >= s.length() || s.charAt(left)!=s.charAt(right))
            return 0;
        return helper(s,left-1,right+1)+1;
    }
}
