package com.jeffrey.leetcode.easy;

public class LengthOfLastWord {

	/*
	 * Problem: 58. Length of Last Word
	 * https://leetcode.com/problems/length-of-last-word/
	 *
	 * Time Complexity: O(N), N = the length of the input s string
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int lengthOfLastWord(String s) {
		int idx = s.length() - 1;
		while (idx >= 0 && s.charAt(idx) == ' ')
			idx--;
		int ans = 0;
		while (idx >= 0 && s.charAt(idx) != ' ') {
			ans++;
			idx--;
		}
		return ans;
	}
}
