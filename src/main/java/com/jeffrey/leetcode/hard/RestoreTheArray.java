package com.jeffrey.leetcode.hard;

import java.util.Arrays;

public class RestoreTheArray {

	/*
	 * Problem: 1416. Restore The Array
	 * https://leetcode.com/problems/restore-the-array/
	 *
	 * Time Complexity: O(N), N = the length of the input s string
	 *
	 * Space Complexity: O(N)
	 *
	 */
	long[] dp;

	public int numberOfArrays(String s, int k) {
		dp = new long[s.length()];
		Arrays.fill(dp, -1);
		return (int) (helper(s.toCharArray(), 0, k) % 1000000007);
	}

	private long helper(char[] arr, int sidx, int k) {
		if (arr.length == sidx)
			return 1;
		if (arr[sidx] == '0')
			return 0;
		if (dp[sidx] != -1)
			return dp[sidx];
		long num = 0L;
		long ans = 0L;
		int picked = 0;
		while (sidx + picked < arr.length) {
			num = num * 10 + arr[sidx + picked] - '0';
			if (num > k)
				break;
			picked++;
			ans += helper(arr, sidx + picked, k);
			ans %= 1000000007;
		}
		dp[sidx] = ans;
		return ans;
	}
}
