package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
	
	/*
	 * Problem: 56. Merge Intervals
	 * https://leetcode.com/problems/merge-intervals/
	 *
	 * Time Complexity: O(N+10000), N = the length of the intervals array
	 *
	 * Space Complexity: O(10000)
	 *
	 */
	public int[][] merge(int[][] intervals) {
        
        int[] all = new int[10001];
        int[] allend = new int[10001];
        for(int[] i : intervals){
            all[i[0]]++;
            allend[i[1]]++;
        }
        List<int[]> list = new ArrayList<int[]>();
        int cur = 0;
        int[] itv = new int[2];
        for(int i=0;i<10000;i++){
            if(all[i]>0){
                if(cur==0)
                    itv[0]=i;
                cur += all[i];
            }
            if(allend[i]>0){
                cur -= allend[i];
                if(cur==0){
                    itv[1]=i;
                    list.add(itv);
                    itv = new int[2];
                }
            }
        }
        int[][] ans = new int[list.size()][2];
        for(int i=0;i<list.size();i++)
            ans[i]=list.get(i);
        return ans;
    }
}
