package com.jeffrey.leetcode.medium;

public class HouseRobber {
	
	/*
	 * Problem: 198. House Robber
	 * https://leetcode.com/problems/house-robber/
	 *
	 * Time Complexity: O(N), N = the length of the nums array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	int[] dp;
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        dp = new int[nums.length];
        dp[nums.length-1] = nums[nums.length-1];
        dp[nums.length-2] = Math.max(nums[nums.length-1],nums[nums.length-2]);
        for(int i = nums.length-3;i>=0;i--){
            dp[i] = Math.max(nums[i]+dp[i+2],dp[i+1]);
        }
        return dp[0];
    }

}
