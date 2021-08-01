package com.jeffrey.leetcode.hard;

public class FindMinimumInRotatedSortedArrayII {

	/*
	 * Problem: 154. Find Minimum in Rotated Sorted Array II
	 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
	 *
	 * Time Complexity: O(N), N = the length of nums array. Even we implement the
	 * code by the binary search idea, the worst case still be O(N)
	 *
	 * Space Complexity: O(logN)
	 *
	 */

	public int findMin(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	private int helper(int[] nums, int s, int e) {
		if (s + 1 >= e)
			return Math.min(nums[s], nums[e]);
		int m = (s + e) / 2;
		if (nums[m] < nums[s])
			return helper(nums, s, m);
		if (nums[m] == nums[s])
			if (nums[m] < nums[e])
				return nums[s];
			else if (nums[m] == nums[e])
				return Math.min(helper(nums, s, m - 1), helper(nums, m + 1, e)); // worst case
		if (nums[m] > nums[e])
			return helper(nums, m, e);

		return helper(nums, s, m);
	}
}
