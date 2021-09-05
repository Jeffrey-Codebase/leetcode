package com.jeffrey.leetcode.medium;

public class NonDecreasingArray {

	/*
	 * Problem: 665. Non-decreasing Array
	 * https://leetcode.com/problems/non-decreasing-array/
	 *
	 * Time Complexity: O(N), N = the length of the nums array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public boolean checkPossibility(int[] nums) {
		boolean change = false;
		if (nums.length == 1)
			return true;
		if (nums[0] > nums[1]) {
			nums[0] = nums[1];
			change = true;
		}
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				if (change)
					return false;
				change = true;
				if (nums[i - 1] <= nums[i + 1])
					nums[i] = nums[i + 1];
				else
					nums[i + 1] = nums[i];
			}
		}
		return true;
	}
}
