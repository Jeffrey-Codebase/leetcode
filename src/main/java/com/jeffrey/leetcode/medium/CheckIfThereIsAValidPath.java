package com.jeffrey.leetcode.medium;

public class CheckIfThereIsAValidPath {

	/*
	 * Problem: 1391. Check if There is a Valid Path in a Grid
	 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
	 *
	 * Time Complexity: O(N*M), N = the number of rows of grid, M = the number of
	 * columns of grid
	 *
	 * Space Complexity: O(N*M)
	 *
	 */
	int[][][] move = new int[][][]{
        {},
        {{0,-1},{0,1}},
        {{-1,0},{1,0}},
        {{0,-1},{1,0}},
        {{0,1},{1,0}},
        {{0,-1},{-1,0}},
        {{0,1},{-1,0}}
    };
    public boolean hasValidPath(int[][] grid) {
        int[] cur = new int[]{0,0};
        int[] adj1 = new int[]{cur[0]+move[grid[cur[0]][cur[1]]][0][0],cur[1]+move[grid[cur[0]][cur[1]]][0][1]};
        int[] adj2 = new int[]{cur[0]+move[grid[cur[0]][cur[1]]][1][0],cur[1]+move[grid[cur[0]][cur[1]]][1][1]};
        return dfs(grid,new boolean[grid.length][grid[0].length],adj1,cur) ||
            dfs(grid,new boolean[grid.length][grid[0].length],adj2,cur);
    }

    private boolean dfs(int[][]grid, boolean[][] visited, int[] cur,int[] pre){
        if(pre[0]==grid.length-1 && pre[1]==grid[0].length-1)
            return true;
        if(cur[0]<0 || cur[1]<0 || cur[0]==grid.length || cur[1]==grid[0].length || visited[cur[0]][cur[1]])
            return false;
        visited[cur[0]][cur[1]] = true;
        int[] adj1 = new int[]{cur[0]+move[grid[cur[0]][cur[1]]][0][0],cur[1]+move[grid[cur[0]][cur[1]]][0][1]};
        int[] adj2 = new int[]{cur[0]+move[grid[cur[0]][cur[1]]][1][0],cur[1]+move[grid[cur[0]][cur[1]]][1][1]};
        if(adj1[0]==pre[0] && adj1[1]==pre[1])
            return dfs(grid,visited,adj2,cur);
        if(adj2[0]==pre[0] && adj2[1]==pre[1])
            return dfs(grid,visited,adj1,cur);
        return false;
    }
}
