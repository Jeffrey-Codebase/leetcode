package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	
	/*
	 * Problem: 49. Group Anagrams
	 * https://leetcode.com/problems/group-anagrams/
	 *
	 * Time Complexity: O(N), N = the length of the strs array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for(String str : strs){
            int[] cnt = new int[26];
            for(char c : str.toCharArray())
                cnt[c-'a']++;
            String key = Arrays.toString(cnt);
            if(!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            List<String> list = map.get(key);
            list.add(str);
           
        }
        return new ArrayList<List<String>>(map.values());
    }
}
