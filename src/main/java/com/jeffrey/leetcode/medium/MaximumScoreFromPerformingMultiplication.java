package com.jeffrey.leetcode.medium;

import java.util.Arrays;

public class MaximumScoreFromPerformingMultiplication {

	/*
	 * Problem: 1770. Maximum Score from Performing Multiplication Operations
	 * https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
	 *
	 * Time Complexity: O(M*M), M = the length of the multipliers array
	 *
	 * Space Complexity: O(M*M)
	 *
	 */
	int[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        dp = new int[multipliers.length][multipliers.length];
        for(int[] r : dp)
            Arrays.fill(r,Integer.MIN_VALUE);
        return helper(nums,multipliers,0,0);
    }
    
    public int helper(int[] nums, int[] mul,int left, int right){
        int midx = left+right;
        if(midx==mul.length) return 0;
        if(dp[left][right]!=Integer.MIN_VALUE) return dp[left][right];
        dp[left][right] = Math.max( 
            nums[left]*mul[midx]+helper(nums,mul,left+1,right),
            nums[nums.length-1-right]*mul[midx]+helper(nums,mul,left,right+1));
        return dp[left][right] ;
    }
}
