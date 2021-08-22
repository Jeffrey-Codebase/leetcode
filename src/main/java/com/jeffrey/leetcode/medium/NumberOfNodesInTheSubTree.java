package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NumberOfNodesInTheSubTree {

	/*
	 * Problem: 1519. Number of Nodes in the Sub-Tree With the Same Label
	 * https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
	 *
	 * Time Complexity: O(N+E), N = the number of nodes in the tree, 
	 *  E = the number of edge in the tree
	 *
	 * Space Complexity: O(N+E)
	 *
	 */
	public int[] countSubTrees(int n, int[][] edges, String labels) {
        int L = labels.length();
        int[] ans = new int[n];
        int[][] dp = new int[n][27];
        char[] label = labels.toCharArray();
        int[] edgeCnt = new int[n];
        edgeCnt[0]=1;
        Map<Integer,List<Integer>> adj = new HashMap<Integer,List<Integer>>();
        for(int[] e : edges){
            if(!adj.containsKey(e[0])){
                adj.put(e[0], new ArrayList<Integer>());
            }
            if(!adj.containsKey(e[1])){
                adj.put(e[1], new ArrayList<Integer>());
            }
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            edgeCnt[e[0]]++;
            edgeCnt[e[1]]++;
        }
        LinkedList<Integer> q = new LinkedList<Integer>();
        for(int i=0; i< n; i++){
            if(edgeCnt[i]==1)
                q.add(i);
        }
        while(q.size()>0){
            int node = q.poll();
            ans[node] = ++dp[node][label[node]-'a'];
            for(int a : adj.get(node)){
                if(dp[a][26]==0){
                    for(int i=0;i<26;i++)
                        dp[a][i] += dp[node][i];
                    edgeCnt[a]--;
                    if(edgeCnt[a]==1)
                        q.add(a);
                    break;
                }
            }
            dp[node][26] = 1;
           
        }
        return ans;
    }
}
