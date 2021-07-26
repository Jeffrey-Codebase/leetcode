package com.jeffrey.leetcode.leetcode_solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestUncommonSubsequenceII {

	/*
	 * Problem: 522. Longest Uncommon Subsequence II
	 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/
	 *
	 * Time Complexity: O(N^2), N = the length of input array
	 *
	 * Space Complexity: O(N)
	 *
	 */

	public int findLUSlength(String[] strs) {
		Set<String> seen = new HashSet<String>();
		Arrays.sort(strs, (s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s2.length() - s1.length());
		for (int i = 0; i < strs.length; i++) {
			if (seen.contains(strs[i]))
				continue;
			if (i == strs.length - 1 || !strs[i].equals(strs[i + 1])) {
				boolean isSub = false;
				for (String s : seen) {
					if (checkSub(s, strs[i])) {
						isSub = true;
						break;
					}
				}
				if (!isSub)
					return strs[i].length();
			}
			seen.add(strs[i]);

		}
		return -1;
	}

	private boolean checkSub(String s1, String s2) {
		int idx1 = 0, idx2 = 0;
		while (idx1 < s1.length() && idx2 < s2.length()) {
			if (s1.charAt(idx1) == s2.charAt(idx2)) {
				idx2++;
			}
			idx1++;
		}
		return idx2 == s2.length();
	}
}
