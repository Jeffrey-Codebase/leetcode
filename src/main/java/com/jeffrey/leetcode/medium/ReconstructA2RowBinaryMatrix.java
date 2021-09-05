package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ReconstructA2RowBinaryMatrix {

	/*
	 * Problem: 1253. Reconstruct a 2-Row Binary Matrix
	 * https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/
	 *
	 * Time Complexity: O(N), N = the length of the colsum array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		List<Integer> up = new ArrayList<Integer>();
		List<Integer> low = new ArrayList<Integer>();
		for (int i = 0; i < colsum.length && upper >= 0 && lower >= 0; i++) {
			if (colsum[i] == 2) {
				up.add(1);
				low.add(1);
				upper--;
				lower--;
			} else if (colsum[i] == 0) {
				up.add(0);
				low.add(0);
			} else if (upper > lower) {
				up.add(1);
				upper--;
				low.add(0);
			} else {
				low.add(1);
				lower--;
				up.add(0);
			}
		}
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if (upper == 0 && lower == 0 && up.size() == colsum.length) {
			ans.add(up);
			ans.add(low);
		}
		return ans;
	}
}
