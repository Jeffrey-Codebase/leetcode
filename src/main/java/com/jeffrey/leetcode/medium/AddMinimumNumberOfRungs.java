package com.jeffrey.leetcode.medium;

public class AddMinimumNumberOfRungs {

	/*
	 * Problem: 1936. Add Minimum Number of Rungs
	 * https://leetcode.com/problems/add-minimum-number-of-rungs/
	 *
	 * Time Complexity: O(N), N = the length of the rungs array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int addRungs(int[] rungs, int dist) {
		int ans = 0;
		int now = 0;
		for (int rung : rungs) {
			if (now + dist < rung)
				ans += (rung - now - 1) / dist;
			now = rung;
		}
		return ans;
	}

}
