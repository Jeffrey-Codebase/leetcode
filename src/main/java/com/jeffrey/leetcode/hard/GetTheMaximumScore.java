package com.jeffrey.leetcode.hard;

public class GetTheMaximumScore {

	/*
	 * Problem: 1537. Get the Maximum Score
	 * https://leetcode.com/problems/get-the-maximum-score/
	 *
	 * Time Complexity: O(max(N,M)), N = the length of the nums1 array, M = the
	 * length of the nums2 array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int maxSum(int[] nums1, int[] nums2) {
		long ans = 0;
		long sum1 = 0, sum2 = 0;
		int idx1 = 0, idx2 = 0;
		while (idx1 < nums1.length && idx2 < nums2.length) {
			if (nums1[idx1] == nums2[idx2]) {
				ans += Math.max(sum1, sum2) + nums1[idx1];
				sum1 = 0;
				sum2 = 0;
				idx1++;
				idx2++;
			} else if (nums1[idx1] < nums2[idx2]) {
				sum1 += nums1[idx1++];
			} else {
				sum2 += nums2[idx2++];
			}
		}

		while (idx1 < nums1.length) {
			sum1 += nums1[idx1++];
		}
		while (idx2 < nums2.length) {
			sum2 += nums2[idx2++];
		}
		ans += Math.max(sum1, sum2);
		return (int) (ans % 1000000007);
	}
}
