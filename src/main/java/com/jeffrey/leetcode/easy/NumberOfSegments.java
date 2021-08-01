package com.jeffrey.leetcode.easy;

public class NumberOfSegments {

	/*
	 * Problem: 434. Number of Segments in a String
	 * https://leetcode.com/problems/number-of-segments-in-a-string/
	 *
	 * Time Complexity: O(N), N = the length of the input s string
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int countSegments(String s) {
		int ans = 0;
		char pre = ' ';
		for (char c : s.toCharArray()) {
			if (pre == ' ' && c != ' ')
				ans++;
			pre = c;
		}
		return ans;
	}
}
