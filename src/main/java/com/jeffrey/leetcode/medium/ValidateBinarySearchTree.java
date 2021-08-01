package com.jeffrey.leetcode.medium;

import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class ValidateBinarySearchTree {

	/*
	 * Problem: 98. Validate Binary Search Tree
	 * https://leetcode.com/problems/validate-binary-search-tree/
	 *
	 * Time Complexity: O(N), N = the number of the nodes in the input tree
	 *
	 * Space Complexity: O(H), H = the height of the tree
	 *
	 */
	Long value = Long.MIN_VALUE;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!isValidBST(root.left)) {
			return false;
		}
		if (root.val <= value) {
			return false;
		} else {
			value = (long) root.val;
		}
		if (!isValidBST(root.right)) {
			return false;
		}
		return true;
	}
}
