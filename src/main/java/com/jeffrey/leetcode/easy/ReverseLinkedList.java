package com.jeffrey.leetcode.easy;

import com.jeffrey.leetcode.builtin.mock.ListNode;

public class ReverseLinkedList {

	
	/*
	 * Problem: 206. Reverse Linked List
	 * https://leetcode.com/problems/reverse-linked-list/
	 *
	 * Time Complexity: O(N), N = the length of the list
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode n1 = null;
        ListNode n2 = head;
        while(n2!=null){
            ListNode temp = n2.next;
            n2.next=n1;
            n1=n2;
            n2=temp;
        }
        return n1;
        
    }
}
