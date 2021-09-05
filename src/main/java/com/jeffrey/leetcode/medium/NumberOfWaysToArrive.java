package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NumberOfWaysToArrive {

	/*
	 * Problem: 1976. Number of Ways to Arrive at Destination
	 * https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
	 *
	 * Time Complexity: O(N + M * logM ), N = the number of the nodes, M = the
	 * number of the roads
	 *
	 * Space Complexity: O(N+M)
	 *
	 */
	public int countPaths(int n, int[][] roads) {
		if (n < 3)
			return 1;
		long ans = 0;
		Map<Integer, List<int[]>> adj = new HashMap<Integer, List<int[]>>();
		for (int[] r : roads) {
			if (!adj.containsKey(r[0]))
				adj.put(r[0], new ArrayList<int[]>());
			if (!adj.containsKey(r[1]))
				adj.put(r[1], new ArrayList<int[]>());
			adj.get(r[0]).add(new int[] { r[1], r[2] });
			adj.get(r[1]).add(new int[] { r[0], r[2] });
		}
		long[] minDis = new long[n];
		long[] pathCnt = new long[n];
		pathCnt[0] = 1;
		Arrays.fill(minDis, Long.MAX_VALUE);
		PriorityQueue<long[]> q = new PriorityQueue<long[]>((i1, i2) -> (int) (i1[1] - i2[1]));
		q.add(new long[] { 0, 0 });
		while (q.size() > 0 && q.peek()[1] <= minDis[n - 1]) {
			long[] p = q.poll();
			int pid = (int) p[0];
			if (minDis[pid] < p[1])
				continue;
			for (int[] a : adj.get(pid)) {
				if (minDis[a[0]] > minDis[pid] + a[1]) {
					minDis[a[0]] = minDis[pid] + a[1];
					pathCnt[a[0]] = pathCnt[pid];
					q.add(new long[] { a[0], minDis[a[0]] });
				} else if (minDis[a[0]] == minDis[pid] + a[1]) {
					pathCnt[a[0]] += pathCnt[pid];
					pathCnt[a[0]] %= 1000000007;
				}
			}
		}

		return (int) (pathCnt[n - 1] % 1000000007);
	}

}
