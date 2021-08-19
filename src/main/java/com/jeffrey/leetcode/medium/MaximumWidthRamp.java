package com.jeffrey.leetcode.medium;

import java.util.LinkedList;

public class MaximumWidthRamp {

	/*
	 * Problem: 962. Maximum Width Ramp
	 * https://leetcode.com/problems/maximum-width-ramp/
	 *
	 * Time Complexity: O(N), N = the length of the nums array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public int maxWidthRamp(int[] nums) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		int ans = 0;
		q.add(0);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[q.peekLast()])
				q.add(i);

		}

		for (int i = nums.length - 1; i > 0 && q.size() > 0; i--) {
			while (q.size() > 0 && nums[q.peekLast()] <= nums[i])
				ans = Math.max(ans, i - q.pollLast());
		}
		return ans;
	}
}

