package com.jeffrey.leetcode.medium;

import java.util.Arrays;

public class DecodeWays {

	/*
	 * Problem: 91. Decode Ways 
	 * https://leetcode.com/problems/decode-ways/
	 *
	 * Time Complexity: O(N), N = the length of the input s string
	 *
	 * Space Complexity: O(N)
	 *
	 */
	private int[] dp;

	public int numDecodings(String s) {
		dp = new int[s.length()];
		Arrays.fill(dp, -1);
		return helper(s, 0);
	}

	private int helper(String s, int idx) {
		if (idx == s.length())
			return 1;
		if (s.charAt(idx) == '0')
			return 0;
		if (idx == s.length() - 1)
			return 1;
		if (dp[idx] >= 0)
			return dp[idx];
		int ans = helper(s, idx + 1);
		if (Integer.valueOf(s.substring(idx, idx + 2)) < 27) {
			ans += helper(s, idx + 2);
		}
		dp[idx] = ans;
		return ans;
	}
}
