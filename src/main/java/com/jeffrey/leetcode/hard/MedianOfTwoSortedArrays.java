package com.jeffrey.leetcode.hard;

public class MedianOfTwoSortedArrays {

	/*
	 * Problem: 4. Median of Two Sorted Arrays
	 * https://leetcode.com/problems/median-of-two-sorted-arrays/
	 *
	 * Time Complexity: O(log(N+M)), N = the length of A1 array, M = the length of
	 * A2 array
	 *
	 * Space Complexity: O(log(N+M))
	 *
	 */

	public double findMedianSortedArrays(int[] A1, int[] A2) {
		int m = A1.length, n = A2.length;
		int mid1 = (m + n + 1) / 2, mid2 = (m + n + 2) / 2;
		return (findKth(A1, 0, A2, 0, mid1) + findKth(A1, 0, A2, 0, mid2)) / 2;
	}

	private double findKth(int[] A1, int s1, int[] A2, int s2, int k) {
		if (s1 == A1.length)
			return A2[s2 + k - 1];
		if (s2 == A2.length)
			return A1[s1 + k - 1];
		if (k == 1)
			return Math.min(A1[s1], A2[s2]);
		int picknum = k / 2;
		int ss1 = (s1 + picknum - 1) < A1.length ? (s1 + picknum - 1) : A1.length - 1;
		int ss2 = (s2 + picknum - 1) < A2.length ? (s2 + picknum - 1) : A2.length - 1;
		if (A1[ss1] < A2[ss2]) {
			return findKth(A1, ss1 + 1, A2, s2, k - (ss1 - s1 + 1));
		} else {
			return findKth(A1, s1, A2, ss2 + 1, k - (ss2 - s2 + 1));
		}

	}

}
