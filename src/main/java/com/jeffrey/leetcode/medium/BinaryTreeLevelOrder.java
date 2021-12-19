package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class BinaryTreeLevelOrder {
	
	/*
	 * Problem: 102. Binary Tree Level Order Traversal
	 * https://leetcode.com/problems/binary-tree-level-order-traversal/
	 *
	 * Time Complexity: O(N), N = the node number of the tree
	 *
	 * Space Complexity: O(H), H = the height of the tree
	 *
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        helper(root,0,ans);
        return ans;
    }
    
    private void helper(TreeNode root, int h, List<List<Integer>> ans){
        if(root==null) return ;
        if(ans.size()==h)
            ans.add(new ArrayList<Integer>());
        ans.get(h).add(root.val);
        helper(root.left, h+1, ans);
        helper(root.right, h+1, ans);
    }
}
