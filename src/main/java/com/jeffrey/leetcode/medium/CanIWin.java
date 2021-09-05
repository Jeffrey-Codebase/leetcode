package com.jeffrey.leetcode.medium;

public class CanIWin {

	/*
	 * Problem: 464. Can I Win
	 * https://leetcode.com/problems/can-i-win/
	 *
	 * Time Complexity: O(2^N), N = the number of maxChoosableInteger
	 *
	 * Space Complexity: O(2^N)
	 *
	 */
	int[] dp;

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if (desiredTotal == 0)
			return true;
		if (((1 + maxChoosableInteger) / 2 * maxChoosableInteger) < desiredTotal) {
			return false;
		}
		int reaminStatus = 0;
		for (int i = 1; i <= maxChoosableInteger; i++) {
			reaminStatus |= 1 << i;
		}
		dp = new int[reaminStatus + 1];
		return helper(maxChoosableInteger, desiredTotal, reaminStatus, 1);
	}

	private boolean helper(int maxChoosableInteger, int remainTotal, int reaminStatus, int user) {
		if (remainTotal <= 0)
			return user == -1;
		if (reaminStatus == 0)
			return false;
		if (dp[reaminStatus] != 0)
			return dp[reaminStatus] == 1;
		if (user == 1) {
			for (int i = 1; i <= maxChoosableInteger; i++) {
				int newStatus = reaminStatus & ~(1 << i);
				if (newStatus < reaminStatus) {
					if (helper(maxChoosableInteger, remainTotal - i, newStatus, -1)) {
						dp[reaminStatus] = 1;
						return true;
					}
				}
			}
			dp[reaminStatus] = -1;
			return false;
		} else {
			for (int i = 1; i <= maxChoosableInteger; i++) {
				int newStatus = reaminStatus & ~(1 << i);
				if (newStatus < reaminStatus) {
					if (!helper(maxChoosableInteger, remainTotal - i, newStatus, 1)) {
						dp[reaminStatus] = -1;
						return false;
					}
				}
			}
			dp[reaminStatus] = 1;
			return true;
		}
	}
}
