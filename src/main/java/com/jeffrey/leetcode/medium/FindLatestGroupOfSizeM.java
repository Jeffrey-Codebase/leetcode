package com.jeffrey.leetcode.medium;

public class FindLatestGroupOfSizeM {
	/*
	 * Problem: 1562. Find Latest Group of Size M
	 * https://leetcode.com/problems/find-latest-group-of-size-m/
	 *
	 * Time Complexity: O(N), N = the length of the arr array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	class Group {
		int s;
		int e;
		int len;

		public Group(int s, int e, int len) {
			this.s = s;
			this.e = e;
			this.len = len;
		}
	}

	public int findLatestStep(int[] arr, int m) {
		int ans = -1;
		int cnt = 0;
		Group[] gs = new Group[arr.length + 2];
		for (int i = 0; i < arr.length; i++) {
			Group left = gs[arr[i] - 1];
			Group right = gs[arr[i] + 1];
			Group g;
			if (left == null) {
				if (right == null) {
					g = new Group(arr[i], arr[i], 1);
				} else {
					g = new Group(arr[i], right.e, right.len + 1);
					if (right.len == m)
						cnt--;
				}
			} else {
				if (right == null) {
					g = new Group(left.s, arr[i], left.len + 1);
					if (left.len == m)
						cnt--;
				} else {
					g = new Group(left.s, right.e, left.len + right.len + 1);
					if (right.len == m)
						cnt--;
					if (left.len == m)
						cnt--;
				}
			}
			gs[g.s] = g;
			gs[g.e] = g;
			if (g.len == m)
				cnt++;
			if (cnt > 0)
				ans = i + 1;
		}
		return ans;
	}

}
