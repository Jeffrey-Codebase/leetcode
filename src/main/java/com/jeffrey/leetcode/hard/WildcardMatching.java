package com.jeffrey.leetcode.hard;

public class WildcardMatching {

	/*
	 * Problem: 44. Wildcard Matching
	 * https://leetcode.com/problems/wildcard-matching/
	 *
	 * Time Complexity: O(N*M), N = the length of the input s string, M = the length
	 * of the input p string
	 *
	 * Space Complexity: O(N*M)
	 *
	 */
	int[][] dp;

	public boolean isMatch(String s, String p) {
		dp = new int[s.length() + 1][p.length() + 1];
		return isMatch(s, 0, p, 0);
	}

	private boolean isMatch(String s, int si, String p, int pi) {

		if (dp[si][pi] != 0)
			return dp[si][pi] == 1;
		if (si == s.length()) {
			while (pi < p.length() && p.charAt(pi) == '*')
				pi++;
			return pi == p.length();
		} else if (pi == p.length()) {
			return false;
		}

		boolean ans = false;
		if (p.charAt(pi) == '*') {
			ans = isMatch(s, si + 1, p, pi) || isMatch(s, si, p, pi + 1);
		} else if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') {
			ans = isMatch(s, si + 1, p, pi + 1);
		}
		dp[si][pi] = ans ? 1 : -1;
		return ans;
	}
}
