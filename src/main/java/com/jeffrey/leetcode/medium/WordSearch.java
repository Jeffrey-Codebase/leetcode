package com.jeffrey.leetcode.medium;

public class WordSearch {

	/*
	 * Problem: 79. Word Search
	 * https://leetcode.com/problems/word-search/
	 *
	 * Time Complexity: O(M * N * 4^L), L = the length of the word
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public boolean exist(char[][] board, String word) {
        char c = word.charAt(0);
        for(int i = 0;i < board.length; i++){
            for(int j=0; j< board[0].length; j++){
                if(board[i][j]==c){
                    if(helper(board,i,j,word,0))
                        return true;
                }
                    
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, int x, int y, String word, int idx){
        if(idx==word.length())
            return true;
        if(x<0 || y<0 || x>= board.length || y>= board[0].length ||
          board[x][y] != word.charAt(idx))
            return false;
        char c = board[x][y];
        board[x][y]='@';
        boolean ans = helper(board,x+1,y,word,idx+1) ||
            helper(board,x,y+1,word,idx+1) ||
            helper(board,x-1,y,word,idx+1) ||
            helper(board,x,y-1,word,idx+1);
        board[x][y]=c;
        return ans;
    }
}
