package com.jeffrey.leetcode.medium;

public class StringToInteger {

	/*
	 * Problem: 8. String to Integer (atoi)
	 * https://leetcode.com/problems/string-to-integer-atoi/
	 *
	 * Time Complexity: O(N), N = the length of the input s string
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int myAtoi(String s) {
		s = s.trim();
		if (s.length() == 0)
			return 0;
		boolean neg = false;
		if (s.charAt(0) == '-') {
			s = s.substring(1);
			neg = true;
		} else if (s.charAt(0) == '+') {
			s = s.substring(1);
		}

		int p = 0, i = 0;
		while (p < s.length() && s.charAt(p) == '0') {
			p++;
			i++;
		}
		for (; i < s.length(); i++) {
			if (s.charAt(i) - '0' < 0 || s.charAt(i) - '9' > 0)
				break;
		}
		if (i == p)
			return 0;
		if (i - p > 10)
			return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		Long num = Long.valueOf(s.substring(p, i));
		if (neg)
			num = 0 - num;
		if (num >= Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (num <= Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return num.intValue();

	}
}
