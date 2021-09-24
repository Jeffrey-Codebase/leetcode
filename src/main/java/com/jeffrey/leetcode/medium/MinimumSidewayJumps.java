package com.jeffrey.leetcode.medium;

public class MinimumSidewayJumps {

	/*
	 * Problem: 1824. Minimum Sideway Jumps
	 * https://leetcode.com/problems/minimum-sideway-jumps/
	 *
	 * Time Complexity: O(N), N = the length of the obstacles array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int minSideJumps(int[] obstacles) {
		int[] dp = new int[3];
		int[] pre = new int[3];
		for (int i = obstacles.length - 2; i >= 0; i--) {
			for (int j = 0; j < 3; j++) {
				if (obstacles[i] - 1 == j)
					dp[j] = -1;
				else if (pre[j] != -1)
					dp[j] = pre[j];
				else {
					int o1 = (j + 1) % 3;
					int o2 = (j + 2) % 3;
					if (obstacles[i] - 1 == o1)
						dp[j] = 1 + pre[o2];
					else if (obstacles[i] - 1 == o2)
						dp[j] = 1 + pre[o1];
					else
						dp[j] = 1 + Math.min(pre[o1], pre[o2]);
				}
			}
			pre = dp;
		}
		return dp[1];
	}
}
