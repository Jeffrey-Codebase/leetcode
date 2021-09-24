package com.jeffrey.leetcode.medium;

public class UniqueSubstringsInWraparoundString {

	/*
	 * Problem: 467. Unique Substrings in Wraparound String
	 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/
	 *
	 * Time Complexity: O(26*N), N = the length of the p string
	 *
	 * Space Complexity: O(26*N)
	 *
	 */
	public int findSubstringInWraproundString(String p) {
		char pre = '@';
		int len = 0;
		int ans = 0;
		boolean[][] seen = new boolean[26][p.length() + 1];
		for (char c : p.toCharArray()) {
			if (c - pre != 1 && !(pre == 'z' && c == 'a'))
				len = 1;
			else
				len++;
			for (int i = len; i > 0; i--) {
				if (!seen[c - 'a'][i]) {
					seen[c - 'a'][i] = true;
					ans++;
				} else {
					break;
				}
			}
			pre = c;
		}
		return ans;
	}
}
