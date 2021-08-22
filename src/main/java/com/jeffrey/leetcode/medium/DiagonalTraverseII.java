package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverseII {

	/*
	 * Problem: 1424. Diagonal Traverse II
	 * https://leetcode.com/problems/diagonal-traverse-ii/
	 *
	 * Time Complexity: O(N), N = the total number of the elements in the nums list
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public int[] findDiagonalOrder(List<List<Integer>> nums) {
		List<List<Integer>> xysum = new ArrayList<List<Integer>>();
		int cnt = 0;
		for (int i = 0; i < nums.size(); i++) {
			List<Integer> row = nums.get(i);
			for (int j = 0; j < row.size(); j++) {
				cnt++;
				int sum = i + j;
				if (sum == xysum.size())
					xysum.add(new ArrayList<Integer>());
				xysum.get(sum).add(row.get(j));
			}
		}
		int[] ans = new int[cnt];
		int idx = 0;
		for (List<Integer> r : xysum) {
			for (int i = r.size() - 1; i >= 0; i--)
				ans[idx++] = r.get(i);
		}
		return ans;
	}
}
