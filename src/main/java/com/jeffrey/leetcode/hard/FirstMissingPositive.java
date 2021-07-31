package com.jeffrey.leetcode.hard;

public class FirstMissingPositive {

	/*
	 * Problem: 41. First Missing Positive
	 * https://leetcode.com/problems/first-missing-positive/
	 *
	 * Time Complexity: O(N), N = the length of the nums array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int firstMissingPositive(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			if (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
				continue;
			}
			i++;
		}
		int idx = 0;
		while (idx < nums.length) {
			if (nums[idx] != idx + 1)
				break;
			idx++;
		}
		return idx + 1;
	}
}
