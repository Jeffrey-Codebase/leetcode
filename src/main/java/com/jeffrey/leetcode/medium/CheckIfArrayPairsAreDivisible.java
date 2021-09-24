package com.jeffrey.leetcode.medium;

public class CheckIfArrayPairsAreDivisible {

	/*
	 * Problem: 1497. Check If Array Pairs Are Divisible by k
	 * https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
	 *
	 * Time Complexity: O(n+k), n = the length of the arr array
	 *
	 * Space Complexity: O(k)
	 *
	 */
	public boolean canArrange(int[] arr, int k) {
		int[] mod = new int[k];
		for (int a : arr) {
			int m = a % k;
			if (m < 0)
				m += k;
			mod[m]++;
		}
		for (int i = 1; i <= k / 2; i++) {
			if (mod[i] != mod[k - i])
				return false;
		}
		if (mod[0] % 2 == 1)
			return false;
		return true;
	}
}
