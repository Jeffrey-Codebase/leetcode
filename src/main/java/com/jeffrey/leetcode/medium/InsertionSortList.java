package com.jeffrey.leetcode.medium;

import com.jeffrey.leetcode.builtin.mock.ListNode;

public class InsertionSortList {
	/*
	 * Problem: 147. Insertion Sort List
	 * https://leetcode.com/problems/insertion-sort-list/
	 *
	 * Time Complexity: O(N*N) , N = the length of the list
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public ListNode insertionSortList(ListNode head) {
		ListNode ans = new ListNode(-10000);
		while (head != null) {
			ListNode p = ans;
			while (p.next != null && p.next.val < head.val) {
				p = p.next;
			}
			ListNode tmp = head.next;
			head.next = p.next;
			p.next = head;
			head = tmp;
		}
		return ans.next;
	}
}
