package com.jeffrey.leetcode.medium;

public class MinimumMovesToMakeArrayComplementary {

	/*
	 * Problem: 1674. Minimum Moves to Make Array Complementary
	 * https://leetcode.com/problems/minimum-moves-to-make-array-complementary/
	 *
	 * Time Complexity: O(N+M), N = the length of the nums array, M = the number of
	 * the limit
	 *
	 * Space Complexity: O(M)
	 *
	 */
	public int minMoves(int[] nums, int limit) {
		int[] change = new int[2 * limit + 2];
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int low = Math.min(nums[left], nums[right]) + 1;
			int high = Math.max(nums[left], nums[right]) + limit + 1;
			int sum = nums[left] + nums[right];
			change[low]--;
			change[sum]--;
			change[sum + 1]++;
			change[high]++;
			left++;
			right--;
		}

		int ans = nums.length;
		int cur = ans;
		for (int n : change) {
			cur += n;
			if (cur < ans)
				ans = cur;
		}
		return ans;
	}
}
