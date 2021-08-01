package com.jeffrey.leetcode.medium;

import com.jeffrey.leetcode.builtin.mock.ListNode;
import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class LinkedListInBinaryTree {

	/*
	 * Problem: 1367. Linked List in Binary Tree
	 * https://leetcode.com/problems/linked-list-in-binary-tree/
	 *
	 * Time Complexity: O(N*M), N = the length of the head list, M = the number of
	 * the nodes in root tree
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public boolean isSubPath(ListNode head, TreeNode root) {
		if (root == null)
			return false;
		return check(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
	}

	private boolean check(TreeNode root, ListNode head) {
		if (head == null)
			return true;
		if (root == null)
			return false;
		if (root.val != head.val)
			return false;
		return check(root.left, head.next) || check(root.right, head.next);
	}

}
