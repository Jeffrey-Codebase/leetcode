package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinimumHeightTrees {

	/*
	 * Problem: 310. Minimum Height Trees
	 * https://leetcode.com/problems/minimum-height-trees/
	 *
	 * Time Complexity: O(N+E), N = the number of the node, E = the number of the
	 * edge
	 *
	 * Space Complexity: O(N+E)
	 *
	 */

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        int[] connect = new int[n];
        for(int[] e : edges){
            if(!map.containsKey(e[0]))
                map.put(e[0],new ArrayList<Integer>());
            if(!map.containsKey(e[1]))
                map.put(e[1],new ArrayList<Integer>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            connect[e[0]]++;
			connect[e[1]]++;
        }
        /* Use Topological Sorting to visit the nodes from leaf to root
         * 
         * If the height is fixed, there will be at most two root nodes
         *      o                o - o
         *    /   \             /     \
         *   o     o           o       o
         *
         */
        int remain = n;
        LinkedList<Integer> q = new LinkedList<Integer>();
        if(n==1) q.add(0);
        for(int i=0;i<n;i++){
            if(connect[i]==1)
                q.add(i);
        }
       
        while(remain>2){
            int len = q.size();
            remain -= len;
            for(int i=0;i<len;i++){
                int node = q.poll();
                for(int cn : map.get(node)){
                    if(--connect[cn]==1)
                        q.add(cn);
                }
            }
        }
        return q;
    }
}
