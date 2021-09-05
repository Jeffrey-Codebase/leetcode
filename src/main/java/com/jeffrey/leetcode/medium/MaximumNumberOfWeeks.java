package com.jeffrey.leetcode.medium;

public class MaximumNumberOfWeeks {

	/*
	 * Problem: 1953. Maximum Number of Weeks for Which You Can Work
	 * https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/
	 *
	 * Time Complexity: O(N), N = the length of the milestones array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public long numberOfWeeks(int[] milestones) {
		int max = 0;
		long sum = 0;
		for (int m : milestones) {
			sum += m;
			max = Math.max(max, m);
		}

		boolean violate = max > (sum + 1) / 2;
		return violate ? (sum - max) * 2 + 1 : sum;

	}
}
