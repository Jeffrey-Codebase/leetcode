package com.jeffrey.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class DeleteColumnstoMakeSortedII {

	/*
	 * Problem: 955. Delete Columns to Make Sorted II
	 * https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
	 *
	 * Time Complexity: O(L*N), L = the length of the string, N = the length of the strs array. 
	 *
	 * Space Complexity: O(N)
	 *
	 */
	
	public int minDeletionSize(String[] strs) {
        int ans =0;
        int preIdx = -1;
        boolean[] pass = new boolean[strs.length];
        // check letter one by one.
        // From 2nd letter, you only need to check the order of the words with same previous letter 
        for(int i=0;i<strs[0].length();i++){
            boolean delete = false;
            Set<Integer> pset = new HashSet<Integer>();
            for(int j=0;j<strs.length-1;j++){
                if(pass[j] ) continue;
                if(strs[j].charAt(i)>strs[j+1].charAt(i)){
                    if(preIdx!=-1 && strs[j].charAt(preIdx)<strs[j+1].charAt(preIdx)){
                       continue;
                    }
                    delete = true;
                    ans++;
                    break;
                }else if (strs[j].charAt(i)<strs[j+1].charAt(i)){
                    pset.add(j);
                    
                }
            }
            if(!delete){
                 preIdx=i; 
                 for(int idx : pset)
                     pass[idx]=true;
            }
              
        }
        return ans;
    }
}
