package com.jeffrey.leetcode.easy;

public class MaximumSubarray {
	
	/*
	 * Problem: 53. Maximum Subarray
	 * https://leetcode.com/problems/maximum-subarray/
	 *
	 * Time Complexity: O(N), N = the length of the nums array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int maxSubArray(int[] nums) {
        int max = -10000;
        int cur = 0;
        for(int n : nums){
            cur+=n;
            max = Math.max(max, cur);
            if(cur<0)
                cur=0;
        }
        return max;
    }

}
