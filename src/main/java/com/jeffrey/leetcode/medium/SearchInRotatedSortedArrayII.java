package com.jeffrey.leetcode.medium;

public class SearchInRotatedSortedArrayII {

	/*
	 * Problem: 81. Search in Rotated Sorted Array II
	 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
	 *
	 * Time Complexity: O(N), N = the length of nums array. Even we implement the
	 * code by the binary search idea, the worst case still be O(N)
	 *
	 * Space Complexity: O(1)
	 *
	 */

	public boolean search(int[] nums, int target) {
		return helper(nums, 0, nums.length - 1, target);
	}

	private boolean helper(int[] nums, int s, int e, int target) {
		// list all possible condition, however, we could summarize the conditions into
		// fewer rules. Reference : FindMinimumInRotatedSortedArrayII
		if (s >= e)
			return nums[s] == target;
		int m = (s + e) / 2;
		if (nums[m] == target)
			return true;
		if (nums[m] < target) {
			if (nums[e] > nums[m]) {
				if (nums[e] < target)
					return helper(nums, s, m - 1, target);
				else
					return helper(nums, m + 1, e, target);
			} else if (nums[e] < nums[m]) {
				return helper(nums, m + 1, e, target);
			} else {
				if (nums[s] < nums[m])
					return false;
				else if (nums[s] > nums[m])
					return helper(nums, s, m - 1, target);
				else
					return helper(nums, s, m - 1, target) || helper(nums, m + 1, e, target); // worst case
			}
		} else {
			if (nums[s] < nums[m]) {
				if (nums[s] <= target)
					return helper(nums, s, m - 1, target);
				else
					return helper(nums, m + 1, e, target);
			} else if (nums[s] > nums[m]) {
				return helper(nums, s, m - 1, target);
			} else {
				if (nums[e] > nums[m])
					return false;
				else if (nums[e] < nums[m])
					return helper(nums, m + 1, e, target);
				else
					return helper(nums, s, m - 1, target) || helper(nums, m + 1, e, target); // worst case
			}
		}
	}
}
