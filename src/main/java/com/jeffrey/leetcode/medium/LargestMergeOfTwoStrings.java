package com.jeffrey.leetcode.medium;

public class LargestMergeOfTwoStrings {

	/*
	 * Problem: 1754. Largest Merge Of Two Strings
	 * https://leetcode.com/problems/largest-merge-of-two-strings/
	 *
	 * Time Complexity: O( max(N,M) * max(N,M)), N = the length of the word1 string,
	 * M = the length of the word2 string
	 *
	 * Space Complexity: O(N+M)
	 *
	 */
	public String largestMerge(String word1, String word2) {
		StringBuilder ans = new StringBuilder();
		int idx1 = 0, idx2 = 0;
		while (idx1 < word1.length() && idx2 < word2.length()) {
			if (word1.charAt(idx1) > word2.charAt(idx2)) {
				ans.append(word1.charAt(idx1++));
			} else if (word1.charAt(idx1) < word2.charAt(idx2)) {
				ans.append(word2.charAt(idx2++));
			} else if (word1.substring(idx1).compareTo(word2.substring(idx2)) > 0) {
				ans.append(word1.charAt(idx1++));
			} else {
				ans.append(word2.charAt(idx2++));
			}
		}
		if (idx1 < word1.length())
			ans.append(word1.substring(idx1));
		if (idx2 < word2.length())
			ans.append(word2.substring(idx2));
		return ans.toString();
	}
}
