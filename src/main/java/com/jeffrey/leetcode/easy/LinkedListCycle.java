package com.jeffrey.leetcode.easy;

import com.jeffrey.leetcode.builtin.mock.ListNode;

public class LinkedListCycle {

	
	/*
	 * Problem: 141. Linked List Cycle
	 * https://leetcode.com/problems/linked-list-cycle/
	 *
	 * Time Complexity: O(N), N = the length of the head list
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode front = head.next;
        while(head!=null&&front!=null&&front.next!=null){
            if(head==front)
                return true;
            head=head.next;
            front = front.next.next;
        }
        return false;
    }
}
