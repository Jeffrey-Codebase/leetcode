package com.jeffrey.leetcode.medium;

import java.util.Arrays;

public class OutOfBoundaryPaths {

	/*
	 * Problem: 576. Out of Boundary Paths
	 * https://leetcode.com/problems/out-of-boundary-paths/
	 *
	 * Time Complexity: O(m*n*maxMove)
	 *
	 * Space Complexity: O(m*n*maxMove)
	 *
	 */

	long[][][] dp;

	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		dp = new long[m][n][maxMove + 1];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				Arrays.fill(dp[i][j], -1);
		return (int) (helper(m, n, maxMove, startRow, startColumn) % 1000000007);
	}

	private long helper(int m, int n, int move, int x, int y) {
		if (x < 0 || x >= m || y < 0 || y >= n)
			return 1;
		if (move == 0)
			return 0;
		if (dp[x][y][move] != -1)
			return dp[x][y][move];
		long ans = 0;
		ans += helper(m, n, move - 1, x + 1, y);
		ans += helper(m, n, move - 1, x - 1, y);
		ans += helper(m, n, move - 1, x, y + 1);
		ans += helper(m, n, move - 1, x, y - 1);
		dp[x][y][move] = ans % 1000000007;

		return ans;
	}
}
