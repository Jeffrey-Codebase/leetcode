package com.jeffrey.leetcode.medium;

public class MinimumElementsToAdd {

	/*
	 * Problem: 1785. Minimum Elements to Add to Form a Given Sum
	 * https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum/
	 *
	 * Time Complexity: O(N), N = the length of the nums array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int minElements(int[] nums, int limit, int goal) {
		long sum = 0;
		for (int n : nums)
			sum += n;
		long dif = Math.abs(goal - sum);
		return (int) (dif / limit + (dif % limit == 0 ? 0 : 1));

	}
}
