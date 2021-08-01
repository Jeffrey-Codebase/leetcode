package com.jeffrey.leetcode.easy;

import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class SecondMinimumNode {

	/*
	 * Problem: 671. Second Minimum Node In a Binary Tree
	 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
	 *
	 * Time Complexity: O(logN), N = the number of nodes in input tree
	 *
	 * Space Complexity: O(H), H = the height of the tree
	 *
	 */

	public int findSecondMinimumValue(TreeNode root) {
		int ans = helper(root, root.val);
		return ans;
	}

	private int helper(TreeNode root, int min) {
		if (root == null)
			return -1;
		if (root.val != min)
			return root.val;
		int right = helper(root.right, min);
		if (right == -1)
			return helper(root.left, min);
		int left = helper(root.left, min);
		if (left == -1)
			return right;
		return Math.min(right, left);
	}
}
