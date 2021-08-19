package com.jeffrey.leetcode.medium;

import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class LongestUnivaluePath {

	/*
	 * Problem: 687. Longest Univalue Path
	 * https://leetcode.com/problems/longest-univalue-path/
	 *
	 * Time Complexity: O(N), N = the number of nodes in the tree
	 *
	 * Space Complexity: O(H), H = the height of the tree
	 *
	 */
	int ans = 1;

	public int longestUnivaluePath(TreeNode root) {
		helper(root);
		return ans - 1;
	}

	private int[] helper(TreeNode root) {
		if (root == null)
			return new int[] { -10000, 0 };
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		if (left[0] == root.val) {
			if (right[0] == root.val) {
				ans = Math.max(ans, left[1] + right[1] + 1);
				return new int[] { root.val, Math.max(left[1], right[1]) + 1 };
			}
			ans = Math.max(ans, ++left[1]);
			return left;
		}
		if (right[0] == root.val) {
			ans = Math.max(ans, ++right[1]);
			return right;
		}
		return new int[] { root.val, 1 };
	}
}
