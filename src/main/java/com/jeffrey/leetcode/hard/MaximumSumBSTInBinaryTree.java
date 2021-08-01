package com.jeffrey.leetcode.hard;

import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class MaximumSumBSTInBinaryTree {

	/*
	 * Problem: 1373. Maximum Sum BST in Binary Tree
	 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
	 *
	 * Time Complexity: O(N), N = the number of the nodes in the input tree
	 *
	 * Space Complexity: O(H), H = the height of the tree
	 *
	 */
	private int ans;

	public int maxSumBST(TreeNode root) {
		checkLeft(root);
		return ans;
	}

	// return the {min value, max value, height} of the left BST
	private int[] checkLeft(TreeNode root) {
		if (root == null)
			return new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE, 0 };
		int[] left = checkLeft(root.left);
		int[] right = checkRight(root.right);
		if (left[1] < root.val && right[0] > root.val) {
			int sum = left[2] + right[2] + root.val;
			ans = Math.max(ans, sum);
			if (right[1] == Integer.MAX_VALUE) {
				right[0] = root.val;
				right[1] = root.val;
			}
			right[2] = sum;
			return right;
		}
		return new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, 0 };
	}

	// return the {min value, max value, height} of the right BST
	private int[] checkRight(TreeNode root) {
		if (root == null)
			return new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, 0 };
		int[] left = checkLeft(root.left);
		int[] right = checkRight(root.right);
		if (left[1] < root.val && right[0] > root.val) {
			int sum = left[2] + right[2] + root.val;
			ans = Math.max(ans, sum);
			if (left[0] == Integer.MIN_VALUE) {
				left[0] = root.val;
				left[1] = root.val;
			}
			left[2] = sum;
			return left;
		}
		return new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE, 0 };
	}
}
