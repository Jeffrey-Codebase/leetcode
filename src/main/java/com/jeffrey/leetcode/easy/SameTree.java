package com.jeffrey.leetcode.easy;

import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class SameTree {
	
	/*
	 * Problem: 100. Same Tree
	 * https://leetcode.com/problems/same-tree/
	 *
	 * Time Complexity: O(min(M,N)), M = the node number of p,
	 * N = the node number of q
	 *
	 * Space Complexity: O(H), H = the max height of the tree
	 *
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null){
            return q==null;
        }else{
            if(q==null || p.val!=q.val)
                return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
        
    }

}
