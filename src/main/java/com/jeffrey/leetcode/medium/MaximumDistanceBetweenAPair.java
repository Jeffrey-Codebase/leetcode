package com.jeffrey.leetcode.medium;

public class MaximumDistanceBetweenAPair {
	/*
	 * Problem: 1855. Maximum Distance Between a Pair of Values
	 * https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
	 *
	 * Time Complexity: O(max(N,M)), N = the length of nums1 array , M = the length
	 * of nums2 array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int maxDistance(int[] nums1, int[] nums2) {
		int idx1 = 0;
		int idx2 = 0;
		int ans = 0;
		while (idx1 < nums1.length && idx2 < nums2.length) {
			if (nums1[idx1] > nums2[idx2])
				idx1++;
			else if (idx2 < idx1)
				idx2 = idx1;
			else {
				ans = Math.max(ans, idx2 - idx1);
				idx2++;
			}
		}
		return ans;
	}
}
