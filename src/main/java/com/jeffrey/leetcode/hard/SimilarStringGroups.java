package com.jeffrey.leetcode.hard;

public class SimilarStringGroups {
	/*
	 * Problem: 839. Similar String Groups
	 * https://leetcode.com/problems/similar-string-groups/
	 *
	 * Time Complexity: O(N*N*M*longN), N = the length of the strs array, M = the
	 * length of the string in strs array
	 *
	 * Space Complexity: O(N)
	 *
	 */

	class Group {
		Group parent;

		public Group getRootGroup() {
			Group g = this;
			while (g.parent != null)
				g = g.parent;
			return g;
		}
	}

	public int numSimilarGroups(String[] strs) {
		int ans = strs.length;
		Group[] groups = new Group[strs.length];
		for (int i = 0; i < strs.length; i++)
			groups[i] = new Group();

		for (int i = 0; i < strs.length; i++) {
			for (int j = i + 1; j < strs.length; j++) {
				if (isSimilar(strs[i], strs[j])) {
					Group g1 = groups[i].getRootGroup();
					Group g2 = groups[j].getRootGroup();
					if (g1 != g2) {
						ans--;
						g2.parent = g1;
					}
				}
			}
		}
		return ans;
	}

	private boolean isSimilar(String s1, String s2) {
		int dif = 0;
		for (int i = 0; i < s1.length(); i++)
			if (s1.charAt(i) != s2.charAt(i)) {
				dif++;
				if (dif > 2)
					return false;
			}
		return true;
	}
}
