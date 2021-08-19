package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SwapForLongestRepeatedChar {

	/*
	 * Problem: 1156. Swap For Longest Repeated Character Substring
	 * https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
	 *
	 * Time Complexity: O(N), N = the length of the input text string
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public int maxRepOpt1(String text) {

		List<int[]> letterGroup = new ArrayList<int[]>();

		int[] letterGroupCnt = new int[26];
		int idx = 0;
		while (idx < text.length()) {
			char c = text.charAt(idx++);
			int[] g = new int[] { c - 'a', 1 };
			while (idx < text.length() && text.charAt(idx) == c) {
				idx++;
				g[1]++;
			}
			letterGroup.add(g);
			letterGroupCnt[g[0]]++;
		}

		int ans = 0;
		int[] left = new int[] { -1, -1 };
		int[] middle = new int[] { -1, -1 };
		for (int i = 0; i < letterGroup.size(); i++) {
			int[] right = letterGroup.get(i);
			// repeated letter could extend length by swapping same letter to it's neighbor
			if (letterGroupCnt[right[0]] == 1) {
				ans = Math.max(ans, right[1]);
			} else {
				ans = Math.max(ans, right[1] + 1);
			}
			// handle the case "aaaXaaaa"
			if (middle[1] == 1) {
				if (right[0] == left[0]) {
					if (letterGroupCnt[right[0]] > 2)
						ans = Math.max(ans, right[1] + left[1] + 1);
					else
						ans = Math.max(ans, right[1] + left[1]);

				}
			}
			left = middle;
			middle = right;
		}

		return ans;
	}
}
