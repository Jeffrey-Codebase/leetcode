package com.jeffrey.leetcode.medium;

public class DivideTwoIntegers {

	/*
	 * Problem: 29. Divide Two Integers
	 * https://leetcode.com/problems/divide-two-integers/
	 *
	 * Time Complexity: O(N), N = the length of the input dividend
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int divide(int dividend, int divisor) {
		long ans = 0;
		int sign = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) ? -1 : 1;
		int overflow = 0;

		if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE)
			return 1;
		else if (dividend == Integer.MIN_VALUE) {
			dividend += Math.abs(divisor);
			overflow = 1;
		} else if (divisor == Integer.MIN_VALUE) {
			return 0;
		}

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		String str = String.valueOf(dividend);
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			int tmpans = 0;
			num = num * 10 + str.charAt(i) - '0';
			while (num >= divisor) {
				num -= divisor;
				tmpans++;
			}
			ans = ans * 10 + tmpans;
		}
		ans += overflow;

		if (ans * sign > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else
			return (int) (ans * sign);

	}
}
