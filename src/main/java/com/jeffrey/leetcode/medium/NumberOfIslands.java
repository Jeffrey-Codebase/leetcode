package com.jeffrey.leetcode.medium;

public class NumberOfIslands {

	
	/*
	 * Problem: 200. Number of Islands
	 * https://leetcode.com/problems/number-of-islands/
	 *
	 * Time Complexity: O(M*N)
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    expand(grid,i,j);
                }
            }
        }
        return ans;
    }
    
    private void expand (char[][] grid, int x, int y){
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || 
           grid[x][y]!='1')
            return;
        grid[x][y]='@';
        expand(grid,x+1,y);
        expand(grid,x-1,y);
        expand(grid,x,y+1);
        expand(grid,x,y-1);
    }
}
