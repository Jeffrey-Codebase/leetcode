package com.jeffrey.leetcode.medium;

public class NumberOfSubstringsWithOnly1s {

	/*
	 * Problem: 1513. Number of Substrings With Only 1s
	 * https://leetcode.com/problems/number-of-substrings-with-only-1s/
	 *
	 * Time Complexity: O(N), N = the length of the s string
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int numSub(String s) {
		long ans = 0;
		long continue1 = 0;
		for (char c : s.toCharArray()) {
			if (c == '1')
				continue1++;
			else if (continue1 > 0) {
				ans += (1 + continue1) * continue1 / 2;
				continue1 = 0;
			}
		}
		ans += (1 + continue1) * continue1 / 2;
		return (int) (ans % 1000000007);
	}
}
