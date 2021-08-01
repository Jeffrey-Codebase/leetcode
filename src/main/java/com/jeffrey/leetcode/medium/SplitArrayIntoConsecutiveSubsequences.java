package com.jeffrey.leetcode.medium;

public class SplitArrayIntoConsecutiveSubsequences {

	/*
	 * Problem: 659. Split Array into Consecutive Subsequences
	 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
	 *
	 * Time Complexity: O(N), N = the length of the nums array
	 *
	 * Space Complexity: O(1), the size of cnt array is fixed
	 *
	 */
	public boolean isPossible(int[] nums) {
		int[] cnt = new int[2001];
		for (int n : nums)
			cnt[n + 1000]++;
		int pre = cnt[2];
		for (int i = 3; i < 2001; i++) {
			if (cnt[i] < pre) {
				// there are gap sequences end at i-1 position
				int gap = pre - cnt[i];
				cnt[i - 1] -= gap;
				cnt[i - 2] -= gap;
				cnt[i - 3] -= gap;
				if (cnt[i - 1] < 0 || cnt[i - 2] < 0 || cnt[i - 3] < 0)
					return false;
			}
			pre = cnt[i];
		}
		return true;
	}
}
