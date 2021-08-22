package com.jeffrey.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumNumberOfPeopleToTeach {

	/*
	 * Problem: 1733. Minimum Number of People to Teach
	 * https://leetcode.com/problems/minimum-number-of-people-to-teach/
	 *
	 * Time Complexity: O(P*N + F*N), P = the length of the languages array, N = the
	 * number of n, F = the length of the friendships array
	 *
	 * Space Complexity: O(P*N)
	 *
	 */
	public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
		Map<Integer, Set<Integer>> lanMap = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < languages.length; i++) {
			Set<Integer> set = new HashSet<Integer>();
			for (int lan : languages[i])
				set.add(lan);
			lanMap.put(i + 1, set);
		}
		Set<Integer> students = new HashSet<Integer>();
		for (int[] fs : friendships) {
			boolean canTalk = false;
			for (int lan : lanMap.get(fs[0])) {
				if (lanMap.get(fs[1]).contains(lan)) {
					canTalk = true;
					break;
				}
			}
			if (!canTalk) {
				students.add(fs[0]);
				students.add(fs[1]);
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int teach = 0;
			for (int p : students)
				if (!lanMap.get(p).contains(i))
					teach++;
			ans = Math.min(ans, teach);
		}
		return ans;

	}
}
