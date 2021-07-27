package com.jeffrey.leetcode.medium;

public class MaximumValueAfterInsertion {

	/*
	 * Problem: 1881. Maximum Value after Insertion
	 * https://leetcode.com/problems/maximum-value-after-insertion/
	 *
	 * Time Complexity: O(N), N = the length of the String n
	 *
	 * Space Complexity: O(1)
	 *
	 */

	public String maxValue(String n, int x) {
		if (n.charAt(0) == '-') {
			for (int i = 1; i < n.length(); i++) {
				if (n.charAt(i) - '0' > x) {
					return n.substring(0, i) + x + n.substring(i);
				}
			}
		} else {
			for (int i = 0; i < n.length(); i++) {
				if (n.charAt(i) - '0' < x) {
					return n.substring(0, i) + x + n.substring(i);
				}
			}

		}
		return n + x;
	}

}
