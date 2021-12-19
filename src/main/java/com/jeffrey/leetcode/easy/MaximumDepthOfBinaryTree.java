package com.jeffrey.leetcode.easy;

import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class MaximumDepthOfBinaryTree {

	/*
	 * Problem: 104. Maximum Depth of Binary Tree
	 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
	 *
	 	 * Time Complexity: O(N), N = the node number of the tree
	 *
	 * Space Complexity: O(H), H = the height of the tree
	 *
	 */
	public int maxDepth(TreeNode root) {
        if(root==null)
           return 0;
       return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
   }  
}
