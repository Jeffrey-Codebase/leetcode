package com.jeffrey.leetcode.medium;

import java.util.Arrays;

public class NonoverlappingIntervals {

	
	/*
	 * Problem: 435. Non-overlapping Intervals
	 * https://leetcode.com/problems/non-overlapping-intervals/
	 *
	 * Time Complexity: O(NlogN), N = the length of the intervals array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a1,a2)->a1[1]-a2[1]);
        int ans = 0;
        int last = Integer.MIN_VALUE;
        for(int[] i : intervals){
            if(i[0]<last)
                ans++;
            else
                last=i[1];
        }
        return ans;
    }
}
