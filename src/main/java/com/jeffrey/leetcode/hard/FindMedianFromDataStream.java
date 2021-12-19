package com.jeffrey.leetcode.hard;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {

	
	/*
	 * Problem: 295. Find Median from Data Stream
	 * https://leetcode.com/problems/find-median-from-data-stream/
	 *
	 * Time Complexity: O(NlogN), N = the number of add operation
	 *
	 * Space Complexity: O(N)
	 *
	 */
	class MedianFinder {

	    PriorityQueue<Integer> upper;
	    PriorityQueue<Integer> lower;
	    
	    public MedianFinder() {
	        upper = new PriorityQueue<Integer>();
	        lower = new PriorityQueue<Integer>((n1,n2)->n2-n1);
	    }
	    
	    public void addNum(int num) {
	        if(lower.size()>upper.size()){
	            lower.add(num);
	            upper.add(lower.poll());
	        }else{
	            upper.add(num);
	            lower.add(upper.poll());
	        }
	        
	    }
	    
	    public double findMedian() {
	        if(lower.size()>upper.size())
	            return lower.peek();
	        return (lower.peek()+upper.peek())/2.0;
	    }
	}
}
