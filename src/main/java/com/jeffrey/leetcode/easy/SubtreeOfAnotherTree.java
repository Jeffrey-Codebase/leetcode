package com.jeffrey.leetcode.easy;

import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class SubtreeOfAnotherTree {

	
	/*
	 * Problem: 572. Subtree of Another Tree
	 * https://leetcode.com/problems/subtree-of-another-tree/
	 *
	 * Time Complexity: O((2^H)*N), N = the node number of the subRoot tree
	 *
	 * Space Complexity: O(H), H = the height of the tree
	 *
	 */
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        int subH = getH(subRoot);
        return helper(root,subRoot,subH) >= 10000;
    }
    
    private int helper(TreeNode node, TreeNode subRoot, int subH){
         
        if(node==null) return 0;
        int H =  Math.max(helper(node.left,subRoot,subH),helper(node.right,subRoot,subH))+1;
        if(H==subH&&same(node,subRoot)){
                return 10000;
        } 
        return H;
    }
    
    private boolean same(TreeNode node, TreeNode subNode){
        if(node==null && subNode==null) return true;
        if(node==null || subNode==null) return false; 
        if(node.val!=subNode.val) return false;
        return same(node.left,subNode.left)
          && same(node.right,subNode.right);    
            
    }
    
    private int getH(TreeNode node){
        if(node==null) return 0;
        return Math.max(getH(node.left),getH(node.right))+1;
    }
}
