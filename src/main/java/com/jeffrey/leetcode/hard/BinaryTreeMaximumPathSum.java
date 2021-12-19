package com.jeffrey.leetcode.hard;

import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class BinaryTreeMaximumPathSum {

	/*
	 * Problem: 124. Binary Tree Maximum Path Sum
	 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
	 *
	 * Time Complexity: O(N), N = the node number of the tree
	 *
	 * Space Complexity: O(1)
	 *
	 */
	private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root){
        if(root==null) return -100000;
        int left = helper(root.left);
        int right = helper(root.right);
        int bigger = Math.max(left,right);
        int feedback =  root.val + (bigger > 0 ? bigger : 0);
        if(left>0 && right>0)
            max = Math.max(max, left+root.val+right);
        else
            max =  Math.max(max, feedback);
        return feedback;           
    }
}
