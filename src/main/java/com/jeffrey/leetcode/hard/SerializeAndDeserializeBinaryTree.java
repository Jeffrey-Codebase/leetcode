package com.jeffrey.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import com.jeffrey.leetcode.builtin.mock.TreeNode;

public class SerializeAndDeserializeBinaryTree {

	/*
	 * Problem: 297. Serialize and Deserialize Binary Tree
	 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
	 *
	 * Time Complexity: O(N), N = the node number of the tree
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public class Codec {

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        List<String> list = new ArrayList<String>();
	        helper(root, list);
	        
	        return String.join(",",list);
	    }
	    
	    private void helper(TreeNode root, List<String> list){
	        if(root==null)
	            list.add("@");
	        else{
	            list.add(String.valueOf(root.val));
	            helper(root.left, list);
	            helper(root.right, list);
	        }
	    }

	    // Decodes your encoded data to tree.
	    private int didx;
	    public TreeNode deserialize(String data) {
	        String[] sa = data.split(",");
	        didx=0;
	        return desHelper(sa);
	    }
	    
	    private TreeNode desHelper(String[] sa){
	      
	        if(sa[didx].equals("@")){
	            didx++;
	            return null;
	        }else{
	            TreeNode root = new TreeNode(Integer.valueOf(sa[didx++]));
	            root.left = desHelper(sa);
	            root.right = desHelper(sa);
	            return root;
	        }
	        
	    }
	}

}
