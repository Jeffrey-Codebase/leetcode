package com.jeffrey.leetcode.medium;

import com.jeffrey.leetcode.builtin.mock.ListNode;

public class ReorderList {

	
	/*
	 * Problem: 143. Reorder List
	 * https://leetcode.com/problems/reorder-list/
	 *
	 * Time Complexity: O(N), N = the length of the head list
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public void reorderList(ListNode head) {
        ListNode hp = head;
        ListNode cur = head;
        helper(hp,cur);
    }
    
    private ListNode helper(ListNode hp, ListNode cur){
        if(cur.next==null){
            if(hp.next==cur) return null;
            ListNode temp = hp.next;
            hp.next = cur;
            cur.next = temp;
            return temp;
        }
      
        ListNode np = helper(hp,cur.next);
        if(np==null) return null;
        ListNode feedback = null;
        if(np==cur)
            np.next = null;
        else if(np.next==cur)
            cur.next = null;
        else{
            feedback = np.next;
            np.next = cur;
            cur.next = feedback;
        }
        return feedback;
        
    }
}
