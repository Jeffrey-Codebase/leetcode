package com.jeffrey.leetcode.medium;

import java.util.LinkedList;

public class AsFarFromLand {

	/*
	 * Problem: 1162. As Far from Land as Possible
	 * https://leetcode.com/problems/as-far-from-land-as-possible/
	 *
	 * Time Complexity: O(N*N), N = the length of the grid array
	 *
	 * Space Complexity: O(N*N)
	 *
	 */
	public int maxDistance(int[][] grid) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid.length; j++)
				if (grid[i][j] == 1)
					q.add(new int[] { i, j });
		if (q.size() == 0 || q.size() == grid.length * grid.length)
			return -1;
		int ans = -1;
		while (q.size() > 0) {
			ans++;
			int len = q.size();
			for (int i = 0; i < len; i++) {
				int[] p = q.poll();
				if (p[0] > 0 && grid[p[0] - 1][p[1]] == 0) {
					grid[p[0] - 1][p[1]] = 1;
					q.add(new int[] { p[0] - 1, p[1] });
				}
				if (p[1] > 0 && grid[p[0]][p[1] - 1] == 0) {
					grid[p[0]][p[1] - 1] = 1;
					q.add(new int[] { p[0], p[1] - 1 });
				}
				if (p[0] < grid.length - 1 && grid[p[0] + 1][p[1]] == 0) {
					grid[p[0] + 1][p[1]] = 1;
					q.add(new int[] { p[0] + 1, p[1] });
				}
				if (p[1] < grid.length - 1 && grid[p[0]][p[1] + 1] == 0) {
					grid[p[0]][p[1] + 1] = 1;
					q.add(new int[] { p[0], p[1] + 1 });
				}
			}
		}
		return ans;
	}
}
