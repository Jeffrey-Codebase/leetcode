package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow {
	
	/*
	 * Problem: 417. Pacific Atlantic Water Flow
	 * https://leetcode.com/problems/pacific-atlantic-water-flow/
	 *
	 * Time Complexity: O(4^R*C), R = the row number of the array,
	 * C = the column number of the array
	 *
	 * Space Complexity: O(R*C)
	 *
	 */
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] po = new boolean[heights.length][heights[0].length];
        LinkedList<int[]> q = new LinkedList<int[]>();
        for(int i=0;i<heights.length;i++){
            po[i][0]=true;
            q.add(new int[]{i,1,heights[i][0]});
        }
        for(int i=1;i<heights[0].length;i++){
            po[0][i]=true;
            q.add(new int[]{1,i,heights[0][i]});
        }
        while(q.size()>0){
            int[] p = q.poll();
            if(p[0]<0 || p[0]>=heights.length || p[1]<0 || p[1]>=heights[0].length||
                 po[p[0]][p[1]]==true || heights[p[0]][p[1]]<p[2])
                    continue;
            po[p[0]][p[1]]=true;
            q.add(new int[]{p[0]+1,p[1],heights[p[0]][p[1]]});
            q.add(new int[]{p[0]-1,p[1],heights[p[0]][p[1]]});
            q.add(new int[]{p[0],p[1]+1,heights[p[0]][p[1]]});
            q.add(new int[]{p[0],p[1]-1,heights[p[0]][p[1]]});
            
        }
        
        for(int i=0;i<heights.length;i++){
            q.add(new int[]{i,heights[0].length-1,-1});
        }
        for(int i=0;i<heights[0].length-1;i++){
            q.add(new int[]{heights.length-1,i,-1});
        }
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        while(q.size()>0){
            int[] p = q.poll();
            if(p[0]<0 || p[0]>=heights.length || p[1]<0 || p[1]>=heights[0].length||
                 heights[p[0]][p[1]]==Integer.MIN_VALUE || heights[p[0]][p[1]]<p[2])
                    continue;
            if(po[p[0]][p[1]]){
                List<Integer> l = new ArrayList<Integer>();
                l.add(p[0]);
                l.add(p[1]);
                ans.add(l);
                
            }           
            q.add(new int[]{p[0]+1,p[1],heights[p[0]][p[1]]});
            q.add(new int[]{p[0]-1,p[1],heights[p[0]][p[1]]});
            q.add(new int[]{p[0],p[1]+1,heights[p[0]][p[1]]});
            q.add(new int[]{p[0],p[1]-1,heights[p[0]][p[1]]});
            heights[p[0]][p[1]]=Integer.MIN_VALUE;
        }
        return ans;
    }
}
