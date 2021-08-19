package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

	/*
	 * Problem: 300. Longest Increasing Subsequence
	 * https://leetcode.com/problems/longest-increasing-subsequence/
	 *
	 * Time Complexity: O(NlogN), N = the length of the nums array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public int lengthOfLIS(int[] nums) {
		List<Integer> lisList = new ArrayList<Integer>();
		for (int n : nums) {
			int idx = Collections.binarySearch(lisList, n);
			if (idx < 0)
				idx = -(idx + 1);
			if (idx == lisList.size())
				lisList.add(n);
			else
				lisList.set(idx, n);
		}
		return lisList.size();
	}
}
