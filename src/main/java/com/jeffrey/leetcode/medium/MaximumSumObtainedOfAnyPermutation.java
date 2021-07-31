package com.jeffrey.leetcode.medium;

import java.util.Arrays;

public class MaximumSumObtainedOfAnyPermutation {

	/*
	 * Problem: 1589. Maximum Sum Obtained of Any Permutation
	 * https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/
	 *
	 * Time Complexity: O(NlogN+M), N = the length of the nums array, M = the length
	 * of the requests array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public int maxSumRangeQuery(int[] nums, int[][] requests) {
		// count how many times each ith numbers be requested
		int[] cnt = new int[nums.length];
		for (int[] r : requests) {
			cnt[r[0]]++;
			if (r[1] + 1 < cnt.length)
				cnt[r[1] + 1]--;
		}
		for (int i = 1; i < cnt.length; i++)
			cnt[i] += cnt[i - 1];

		// the bigger the number, the more times the number should be count
		Arrays.sort(nums);
		Arrays.sort(cnt);
		long ans = 0;
		for (int i = nums.length - 1; i >= 0 && cnt[i] > 0; i--) {
			ans += (long) nums[i] * cnt[i];
			ans %= 1000000007;
		}

		return (int) ans;
	}
}
