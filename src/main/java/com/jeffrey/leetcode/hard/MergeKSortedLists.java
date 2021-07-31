package com.jeffrey.leetcode.hard;

import com.jeffrey.leetcode.builtin.mock.ListNode;

public class MergeKSortedLists {

	/*
	 * Problem: 23. Merge k Sorted Lists
	 * https://leetcode.com/problems/merge-k-sorted-lists/
	 *
	 * Time Complexity: O(NlogM), N = the number of ListNode in whole lists, M = the
	 * length of the lists array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		return helper(lists, 0, lists.length - 1);
	}

	// divide and conquer
	private ListNode helper(ListNode[] lists, int i, int j) {
		if (i == j)
			return lists[i];
		int m = (i + j) / 2;
		ListNode left = helper(lists, i, m);
		ListNode right = helper(lists, m + 1, j);
		ListNode head = new ListNode();
		ListNode p = head;
		while (left != null && right != null) {
			if (left.val < right.val) {
				p.next = left;
				p = p.next;
				left = left.next;
			} else {
				p.next = right;
				p = p.next;
				right = right.next;
			}
		}
		if (left != null)
			p.next = left;
		else
			p.next = right;
		return head.next;
	}
}
