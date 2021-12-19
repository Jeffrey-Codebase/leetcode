package com.jeffrey.leetcode.medium;

import java.util.HashMap;

import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class ConstructBinaryTree {

	
	/*
	 * Problem: 105. Construct Binary Tree from Preorder and Inorder Traversal
	 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
	 *
	 * Time Complexity: O(N), N = the length of the preorder array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> idxMap = new HashMap<Integer,Integer>();
        for(int i=0; i<inorder.length;i++)
            idxMap.put(inorder[i],i);
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,idxMap);
        
    }
    
    public TreeNode helper(int[] preorder,int ps, int pe, int[] inorder,int is, int ie,
                          HashMap<Integer,Integer> idxMap){
        if(ie<is) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        
        int ridx = idxMap.get(preorder[ps]);
        int leftCnt = ridx-is;
        
        root.left = helper(preorder,ps+1,ps+leftCnt,inorder,is,ridx-1,idxMap);
        root.right = helper(preorder,ps+leftCnt+1,pe,inorder,ridx+1,ie,idxMap);
        return root;
    }
}
