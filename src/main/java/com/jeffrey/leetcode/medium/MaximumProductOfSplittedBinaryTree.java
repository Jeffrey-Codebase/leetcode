package com.jeffrey.leetcode.medium;

import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class MaximumProductOfSplittedBinaryTree {

	/*
	 * Problem: 1339. Maximum Product of Splitted Binary Tree
	 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
	 *
	 * Time Complexity: O(N), N = the number of the nodes in the tree
	 *
	 * Space Complexity: O(1)
	 *
	 */
	long sum = 0;
	long ans = 0;

	public int maxProduct(TreeNode root) {
		travel(root);
		helper(root);
		return (int) (ans % 1000000007);
	}

	private void travel(TreeNode root) {
		if (root == null)
			return;
		sum += root.val;
		travel(root.left);
		travel(root.right);
	}

	private long helper(TreeNode root) {
		if (root == null)
			return 0;
		long subsum = root.val + helper(root.left) + helper(root.right);
		ans = Math.max(ans, subsum * (sum - subsum));
		return subsum;
	}
}
