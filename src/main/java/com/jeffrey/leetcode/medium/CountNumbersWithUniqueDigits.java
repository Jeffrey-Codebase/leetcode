package com.jeffrey.leetcode.medium;

public class CountNumbersWithUniqueDigits {

	/*
	 * Problem: 357. Count Numbers with Unique Digits
	 * https://leetcode.com/problems/count-numbers-with-unique-digits/
	 *
	 * Time Complexity: O(N), N = the input number n
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0)
			return 1;
		int[] factorial = new int[10];
		int p = 1;
		for (int i = 1; i < 10; i++) {
			p *= i;
			factorial[i] = p;
		}
		int ans = 10;
		for (int i = 2; i <= n; i++) {
			ans += 9 * factorial[9] / factorial[9 - i + 1];
		}
		return ans;

	}
}
