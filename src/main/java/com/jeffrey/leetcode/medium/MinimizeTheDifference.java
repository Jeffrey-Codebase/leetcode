package com.jeffrey.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class MinimizeTheDifference {

	/*
	 * Problem: 1981. Minimize the Difference Between Target and Chosen Elements
	 * https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/
	 *
	 * Time Complexity: O(M*N*T), M = the number of columns of mat,
	 * N = the number of rows of mat, T = the number of target
	 *
	 * Space Complexity: O(N+T)
	 *
	 */
	public int minimizeTheDifference(int[][] mat, int target) {
		Set<Integer> sum = new HashSet<Integer>();
		int C = mat.length;
		int R = mat[0].length;
		int[] minsum = new int[C + 1];
		for (int i = C - 1; i >= 0; i--) {
			int min = mat[i][0];
			for (int j = 1; j < R; j++)
				min = Math.min(min, mat[i][j]);
			minsum[i] = min + minsum[i + 1];
		}

		sum.add(0);
		for (int i = 0; i < C; i++) {
			Set<Integer> localsum = new HashSet<Integer>();
			int gate = target - minsum[i + 1];
			int minBigger = Integer.MAX_VALUE;
			for (int j = 0; j < R; j++) {
				for (int s : sum) {
					int num = mat[i][j] + s;
					if (num >= gate)
						minBigger = Math.min(minBigger, num);
					else
						localsum.add(num);
				}
			}
			if (minBigger != Integer.MAX_VALUE)
				localsum.add(minBigger);
			sum = localsum;
		}
		int ans = Integer.MAX_VALUE;
		for (int s : sum)
			ans = Math.min(ans, Math.abs(target - s));
		return ans;
	}
}
