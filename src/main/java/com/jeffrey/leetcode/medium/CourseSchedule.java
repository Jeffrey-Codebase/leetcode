package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
	
	/*
	 * Problem: 207. Course Schedule
	 * https://leetcode.com/problems/course-schedule/
	 *
	 * Time Complexity: O(N+P), N = the number of courses, 
	 * P = the length of the prerequisites array
	 *
	 * Space Complexity: O(P)
	 *
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preCnt = new int[numCourses];
        Map<Integer,List<Integer>> cmap = new HashMap<Integer,List<Integer>>();
        for(int[] p : prerequisites){
            preCnt[p[1]]++;
            if(!cmap.containsKey(p[0]))
                cmap.put(p[0], new ArrayList<Integer>());
            cmap.get(p[0]).add(p[1]);
        }
        LinkedList<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<preCnt.length; i++){
            if(preCnt[i]==0)
                q.add(i);
        }
        int finish = 0;
        while(q.size()>0){
            finish++;
            int c = q.poll();
            if(cmap.containsKey(c)){
                for(int n : cmap.get(c)){
                    preCnt[n]--;
                    if(preCnt[n]==0)
                        q.add(n);
                }
            }
            
        }
        return finish == numCourses;
    }

}
