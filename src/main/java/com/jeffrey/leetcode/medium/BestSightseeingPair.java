package com.jeffrey.leetcode.medium;

public class BestSightseeingPair {

	/*
	 * Problem: 1014. Best Sightseeing Pair
	 * https://leetcode.com/problems/best-sightseeing-pair/
	 *
	 * Time Complexity: O(N), N = the length of the input values array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int maxScoreSightseeingPair(int[] values) {
		int ans = 0;
		int pre = values[0];
		for (int i = 1; i < values.length; i++) {
			ans = Math.max(ans, values[i] + pre);
			pre = Math.max(pre - 1, values[i]);
		}
		return ans - 1;
	}
}
