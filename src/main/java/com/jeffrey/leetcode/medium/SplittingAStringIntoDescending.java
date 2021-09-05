package com.jeffrey.leetcode.medium;

public class SplittingAStringIntoDescending {

	/*
	 * Problem: 1849. Splitting a String Into Descending Consecutive Values
	 * https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/
	 *
	 * Time Complexity: O(N*N), N = the length of s string
	 *
	 * Space Complexity: O(1)
	 *
	 */
    public boolean splitString(String s) {
        long first=0;
		// find the first number of the sequence
        for(int i=0;i<s.length()-1;i++){
            first = first*10+s.charAt(i)-'0';
            if(helper(first,s,i+1))
                return true;
        }
        return false;
    }
    
    private boolean helper(long pre, String s, int idx){
       
        long next = 0;
		// check the next number is equal to (previous number -1)
        for(int i =idx;i<s.length();i++){
            next = next*10+s.charAt(i)-'0';
            if(next==0 && i!=s.length()-1) continue;
            if(pre-1==next){
                pre=next;
                next=0;
            }else if(next>=pre || i==s.length()-1){
                return false;
            }
        }
        return true;
        
    }
}
