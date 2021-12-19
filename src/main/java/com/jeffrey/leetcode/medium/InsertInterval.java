package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	
	/*
	 * Problem: 57. Insert Interval
	 * https://leetcode.com/problems/insert-interval/
	 *
	 * Time Complexity: O(N), N = the length of the intervals array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0) return new int[][]{newInterval};
        int left = search(intervals,0,intervals.length-1,newInterval[0]);
        int right = search(intervals,0,intervals.length-1,newInterval[1]);
        List<int[]> list = new ArrayList<int[]>();
        for(int i=0;i<left;i++)
            list.add(intervals[i]);
        if(left==-1){
            if(right>=0)
                newInterval[1] = Math.max(newInterval[1],intervals[right][1]);
            list.add(newInterval); 
        }else{
            if(intervals[left][1]>=newInterval[0])
                newInterval[0] = intervals[left][0];
            else
                list.add(intervals[left]); 
            newInterval[1] = Math.max(newInterval[1],intervals[right][1]);
            list.add(newInterval); 
        }
         for(int i=right+1;i<intervals.length;i++)
            list.add(intervals[i]);
        
        int[][] ans = new int[list.size()][2];
        list.toArray(ans);
        return ans;
        
    }
    
    private int search(int[][] ins, int s, int e, int target){
        if(s==e){
            if(ins[s][0]<=target) return s;
            return s-1;
        }else{
            int m = (s+e)/2;
            if(ins[m][0]==target) return m;
            else if(ins[m][0] < target) return search(ins,m+1,e,target);
            return search(ins,s,m,target);
        }
    }
}
