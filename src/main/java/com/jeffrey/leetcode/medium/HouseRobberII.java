package com.jeffrey.leetcode.medium;

public class HouseRobberII {

	
	/*
	 * Problem: 213. House Robber II
	 * https://leetcode.com/problems/house-robber-ii/
	 *
	 * Time Complexity: O(N), N = the length of the nums array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	 public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dpn = new int[nums.length];
        dp1[nums.length-1]=0;
        dp1[nums.length-2]=nums[nums.length-2];
        dpn[nums.length-1]=nums[nums.length-1];
        dpn[nums.length-2]=Math.max(nums[nums.length-1], nums[nums.length-2]);
        for(int i = nums.length-3;i>=0;i--){
            dp1[i] = Math.max(nums[i]+dp1[i+2],dp1[i+1]);
            dpn[i] = Math.max(nums[i]+dpn[i+2],dpn[i+1]);
        }
        return Math.max(dp1[0],dpn[1]);
    }
}
