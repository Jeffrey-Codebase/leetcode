package com.jeffrey.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class FindRightInterval {

	/*
	 * Problem: 436. Find Right Interval
	 * https://leetcode.com/problems/find-right-interval/
	 *
	 * Time Complexity: O(NlogN), N = the length of the intervals array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public int[] findRightInterval(int[][] intervals) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		TreeSet<Integer> seen = new TreeSet<Integer>((i1, i2) -> i1 - i2);
		int[] ans = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			if (seen.add(intervals[i][0])) {
				map.put(intervals[i][0], i);
			}
		}
		for (int i = 0; i < intervals.length; i++) {
			Integer value = seen.ceiling(intervals[i][1]);
			ans[i] = value == null ? -1 : map.get(value);
		}
		return ans;
	}
}
