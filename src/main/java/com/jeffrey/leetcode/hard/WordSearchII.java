package com.jeffrey.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

	
	/*
	 * Problem: 212. Word Search II
	 * https://leetcode.com/problems/word-search-ii/
	 *
	 * Time Complexity: O(W*L + R*C*L), W = the length of the words array,
	 * L = the max length of the words, R = the row number of the board,
	 * C = the column number of the board
	 *
	 * Space Complexity: O(L^26)
	 *
	 */
	class TrieNode{
        String word;
        TrieNode[] child;
        public TrieNode(){
            child = new TrieNode[26];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
            
        TrieNode root = new TrieNode();
        for(String s : words){
            TrieNode p = root;
            for(char c : s.toCharArray()){
                int idx = c - 'a';
                if(p.child[idx]==null){
                    p.child[idx] = new TrieNode();
                }
                p = p.child[idx];
            }
            p.word = s;
        }
        
        Set<String> ans = new HashSet<String>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                helper(board,i,j,root,ans);
            }
        }
        return new ArrayList<String>(ans);

    }
    
    public void helper(char[][] board, int x, int y, TrieNode node, Set<String> ans){
        
        if(x<0 || y<0 || x>= board.length || y>=board[0].length ||board[x][y]=='@'||
          node.child[board[x][y]-'a']==null)
            return ;
        TrieNode n = node.child[board[x][y]-'a'];
        if(n.word!=null)
            ans.add(n.word);
        char temp = board[x][y];
        board[x][y] = '@';
        helper(board,x+1,y,n,ans);
        helper(board,x-1,y,n,ans);
        helper(board,x,y+1,n,ans);
        helper(board,x,y-1,n,ans);
        board[x][y] = temp;
    }
}
