package com.jeffrey.leetcode.medium;

public class MinimumLengthOfStringAfterDeleting {

	/*
	 * Problem: 1750. Minimum Length of String After Deleting Similar Ends
	 * https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
	 *
	 * Time Complexity: O(N), N = the length of the s string
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int minimumLength(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j && s.charAt(i) == s.charAt(j)) {
			char c = s.charAt(i);
			while (i <= j && s.charAt(i) == c)
				i++;
			while (i <= j && s.charAt(j) == c)
				j--;
		}
		return j >= i ? j - i + 1 : 0;
	}
}
