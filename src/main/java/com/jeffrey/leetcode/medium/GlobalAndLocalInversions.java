package com.jeffrey.leetcode.medium;

public class GlobalAndLocalInversions {
	/*
	 * Problem: 775. Global and Local Inversions
	 * https://leetcode.com/problems/global-and-local-inversions/
	 *
	 * Time Complexity: O(N), N = the length of the nums array
	 *
	 * Space Complexity: O(1)
	 *
	 */

	public boolean isIdealPermutation(int[] nums) {
		if (nums.length <= 2)
			return true;
		int preMax = nums[0];

		for (int i = 2; i < nums.length; i++) {
			if (preMax > nums[i])
				return false;
			preMax = Math.max(preMax, nums[i - 1]);
		}
		return true;

	}
}
