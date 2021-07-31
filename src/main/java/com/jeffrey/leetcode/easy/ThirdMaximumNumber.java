package com.jeffrey.leetcode.easy;

public class ThirdMaximumNumber {

	/*
	 * Problem: 414. Third Maximum Number
	 * https://leetcode.com/problems/third-maximum-number/
	 *
	 * Time Complexity: O(N), N = the length of the nums array
	 *
	 * Space Complexity: O(1)
	 *
	 */

	public int thirdMax(int[] nums) {
		long one = Integer.MIN_VALUE - 1L;
		long two = Integer.MIN_VALUE - 1L;
		long three = Integer.MIN_VALUE - 1L;
		for (int n : nums) {
			if (n > one) {
				three = two;
				two = one;
				one = n;
			} else if (n > two) {
				if (n == one)
					continue;
				three = two;
				two = n;
			} else if (n > three) {
				if (n == two)
					continue;
				three = n;
			}
		}
		return three < Integer.MIN_VALUE ? (int) one : (int) three;
	}
}
