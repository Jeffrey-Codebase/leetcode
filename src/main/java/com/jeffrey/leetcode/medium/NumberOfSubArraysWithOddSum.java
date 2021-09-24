package com.jeffrey.leetcode.medium;

public class NumberOfSubArraysWithOddSum {

	/*
	 * Problem: 1524. Number of Sub-arrays With Odd Sum
	 * https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
	 *
	 * Time Complexity: O(N), N = the length of the arr array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int numOfSubarrays(int[] arr) {
		int even = 0;
		int odd = 0;
		long ans = 0;
		for (int a : arr) {
			if (a % 2 == 0) {
				even++;
			} else {
				int temp = odd;
				odd = even + 1;
				even = temp;

			}
			ans += odd;
		}
		return (int) (ans % 1000000007);
	}
}
