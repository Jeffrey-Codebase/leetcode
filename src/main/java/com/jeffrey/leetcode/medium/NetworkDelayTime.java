package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {

	/*
	 * Problem: 743. Network Delay Time
	 * https://leetcode.com/problems/network-delay-time/
	 *
	 * Time Complexity: O(NlogN), N = the length of times array
	 *
	 * Space Complexity: O(V+N), V = the numbers of nodes
	 *
	 */
	public int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer, List<int[]>> edges = new HashMap<Integer, List<int[]>>();
		for (int[] e : times) {
			if (!edges.containsKey(e[0]))
				edges.put(e[0], new ArrayList<int[]>());
			edges.get(e[0]).add(e);
		}
		int[] min = new int[n + 1];
		int reach = 1;
		Arrays.fill(min, Integer.MAX_VALUE);
		min[k] = 0;
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a1, a2) -> a1[1] - a2[1]);
		if (!edges.containsKey(k))
			return -1;
		for (int[] e : edges.get(k)) {
			q.add(new int[] { e[1], e[2] });
		}
		int ans = 0;
		while (q.size() > 0 && reach < n) {
			int[] p = q.poll();
			if (min[p[0]] != Integer.MAX_VALUE)
				continue;
			reach++;
			min[p[0]] = p[1];
			ans = Math.max(ans, p[1]);
			if (edges.containsKey(p[0])) {
				for (int[] e : edges.get(p[0])) {
					if (min[e[1]] == Integer.MAX_VALUE)
						q.add(new int[] { e[1], p[1] + e[2] });
				}
			}
		}
		if (reach < n)
			return -1;
		return ans;

	}
}
