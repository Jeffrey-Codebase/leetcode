package com.jeffrey.leetcode.easy;

import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class InvertBinaryTree {

	/*
	 * Problem: 226. Invert Binary Tree
	 * https://leetcode.com/problems/invert-binary-tree/
	 *
	 * Time Complexity: O(N), N = the node number of the tree
	 *
	 * Space Complexity: O(H), H = the height of the tree
	 *
	 */
	 public TreeNode invertTree(TreeNode root) {
	        if(root!=null){
	            TreeNode left = invertTree(root.left);
	            TreeNode right = invertTree(root.right);
	            root.right = left;
	            root.left = right;
	        }
	        return root;
	    }
}
