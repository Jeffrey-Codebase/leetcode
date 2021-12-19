package com.jeffrey.leetcode.medium;

import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class KthSmallestElement {

	/*
	 * Problem: 230. Kth Smallest Element in a BST
	 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
	 *
	 * Time Complexity: O(k)
	 *
	 * Space Complexity: O(1)
	 *
	 */
	private int cnt;
    public int kthSmallest(TreeNode root, int k) {
        cnt=0;
        return helper(root,k);
    }
    public int helper(TreeNode root, int k) {
        if(root != null){
            int left = helper(root.left,k);
            if(left!=-1) return left;
            cnt++;
            if(k==cnt) return root.val;
            return helper(root.right,k);
        }
        return -1;
    }
}
