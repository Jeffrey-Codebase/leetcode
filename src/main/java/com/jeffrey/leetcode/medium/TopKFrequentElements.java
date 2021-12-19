package com.jeffrey.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	/*
	 * Problem: 347. Top K Frequent Elements
	 * https://leetcode.com/problems/top-k-frequent-elements/
	 *
	 * Time Complexity: O(N*LogK), N = the length of the nums array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<Integer,Integer>();
        for(int n:nums){
            cnt.put(n,cnt.getOrDefault(n,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1,n2)->cnt.get(n1)-cnt.get(n2));
        for(int n : cnt.keySet()){
            pq.add(n);
            if(pq.size()>k)
                pq.poll();
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++)
            ans[i]=pq.poll();
        
        return ans;
    }
}
