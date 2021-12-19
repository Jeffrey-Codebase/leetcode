package com.jeffrey.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MinimumWindowSubstring {

	
	/*
	 * Problem: 76. Minimum Window Substring
	 * https://leetcode.com/problems/minimum-window-substring/
	 *
	 * Time Complexity: O(M+N), M = the length of the s string,
	 * N = the length of the t string
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public String minWindow(String s, String t) {
        String ans = "";
        int need = t.length();
        Map<Character,Integer> cnt = new HashMap<Character, Integer>();
        for(char c : t.toCharArray()){
            cnt.put(c,cnt.getOrDefault(c,0)+1);
        }
        LinkedList<Integer> w = new LinkedList<Integer>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(cnt.containsKey(c)){
                w.add(i);
                int ncnt = cnt.get(c)-1;
                cnt.put(c,ncnt);
                
                if(ncnt>=0){
                    need--;    
                    while(need==0){
                        int idx = w.poll();
                        char wc = s.charAt(idx);
                        int wcnt = cnt.get(wc)+1;
                        cnt.put(wc,wcnt);
                        if(wcnt>0){
                            if(ans.length()==0 || ans.length()>(i-idx+1))
                                ans = s.substring(idx,i+1);    
                            need++;
                        }
                    }
                    
                }
            }
            
        }
        return ans;
    }
}
