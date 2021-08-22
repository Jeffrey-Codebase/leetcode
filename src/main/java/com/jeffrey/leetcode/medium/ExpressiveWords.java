package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {

	/*
	 * Problem: 809. Expressive Words
	 * https://leetcode.com/problems/expressive-words/
	 *
	 * Time Complexity: O(S+W*MAX(S,L)), S = the length of s string, W = the length of words array,
	 * L = the max length of the word in words array
	 *
	 * Space Complexity: O(MAX(S,L)),
	 *
	 */
	public int expressiveWords(String s, String[] words) {
		int ans = 0;
		List<int[]> ts = transform(s);
		for (String w : words) {
			List<int[]> tw = transform(w);
			if (ts.size() != tw.size())
				continue;
			boolean stretchy = true;
			for (int i = 0; i < ts.size(); i++) {
				int[] tsi = ts.get(i);
				int[] twi = tw.get(i);
				if (tsi[0] != twi[0] || tsi[1] < twi[1] || (tsi[1] != twi[1] && tsi[1] < 3)) {
					stretchy = false;
					break;
				}
			}
			if (stretchy)
				ans++;
		}
		return ans;
	}

	private List<int[]> transform(String s) {
		List<int[]> ans = new ArrayList<int[]>();
		char c = s.charAt(0);
		int len = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != c) {
				ans.add(new int[] { c, len });
				c = s.charAt(i);
				len = 1;
			} else {
				len++;
			}
		}
		ans.add(new int[] { c, len });
		return ans;
	}
}
