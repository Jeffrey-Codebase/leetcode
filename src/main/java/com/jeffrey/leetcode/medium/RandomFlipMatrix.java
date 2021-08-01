package com.jeffrey.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class RandomFlipMatrix {

	/*
	 * Problem: 519. Random Flip Matrix
	 * https://leetcode.com/problems/random-flip-matrix/
	 *
	 * Time Complexity: O(1)
	 *
	 * Space Complexity: O(M*N), M = the number of rows, N = the number of columns
	 *
	 */

	int len;
	Map<Integer, Integer> map;
	int col;
	int row;

	public RandomFlipMatrix(int n_rows, int n_cols) {
		row = n_rows;
		col = n_cols;
		len = n_rows * n_cols;
		map = new HashMap<Integer, Integer>();
	}

	// create a pointer pointed to the lastest un-flipped item
	public int[] flip() {
		int random = (int) (Math.random() * len);
		int idx = map.containsKey(random) ? map.get(random) : random;
		int[] ans = new int[] { idx / col, idx % col };
		len--;
		map.put(random, map.getOrDefault(len, len));
		return ans;
	}

	public void reset() {
		map.clear();
		len = col * row;
	}
}
