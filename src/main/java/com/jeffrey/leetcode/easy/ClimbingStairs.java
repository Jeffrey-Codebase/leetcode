package com.jeffrey.leetcode.easy;

public class ClimbingStairs {

	/*
	 * Problem: 70. Climbing Stairs
	 * https://leetcode.com/problems/climbing-stairs/
	 *
	 * Time Complexity: O(n)
	 *
	 * Space Complexity: O(n)
	 *
	 */
	public int climbStairs(int n) {
        int[] dp = new int[46];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
