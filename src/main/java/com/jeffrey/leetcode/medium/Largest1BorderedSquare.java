package com.jeffrey.leetcode.medium;

public class Largest1BorderedSquare {

	/*
	 * Problem: 1139. Largest 1-Bordered Square
	 * https://leetcode.com/problems/largest-1-bordered-square/
	 *
	 * Time Complexity: O(R*C*min(R,C)), R = the row number of the grid, C = the
	 * column number of the grid
	 *
	 * Space Complexity: O(R*C)
	 *
	 */
	public int largest1BorderedSquare(int[][] grid) {
		int R = grid.length;
		int C = grid[0].length;
		int[][] up1 = new int[R][C];
		int[][] left1 = new int[R][C];
		left1[0][0] = grid[0][0];
		up1[0][0] = grid[0][0];
		for (int i = 1; i < R; i++) {
			if (grid[i][0] == 1) {
				left1[i][0] = 1;
				up1[i][0] = 1 + up1[i - 1][0];
			}
		}
		for (int j = 1; j < C; j++) {
			if (grid[0][j] == 1) {
				up1[0][j] = 1;
				left1[0][j] = 1 + left1[0][j - 1];
			}
		}
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (grid[i][j] == 1) {
					up1[i][j] = 1 + up1[i - 1][j];
					left1[i][j] = 1 + left1[i][j - 1];
				}
			}
		}

		int maxW = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 1) {
					int w = Math.min(up1[i][j], left1[i][j]);
					for (int k = w; k > maxW; k--) {
						if (left1[i - k + 1][j] >= k && up1[i][j - k + 1] >= k) {
							maxW = k;
							break;
						}
					}
				}
			}
		}
		return maxW * maxW;

	}
}
