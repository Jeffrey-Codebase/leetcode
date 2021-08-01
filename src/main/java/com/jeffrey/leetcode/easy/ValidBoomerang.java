package com.jeffrey.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ValidBoomerang {

	/*
	 * Problem: 1037. Valid Boomerang
	 * https://leetcode.com/problems/valid-boomerang/
	 *
	 * Time Complexity: O(1), the number of input points is fixed 3.
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public boolean isBoomerang(int[][] points) {
        Set<Integer> seen = new HashSet<Integer>();
        for(int[] p : points){
            int num = p[0]*1000+p[1];
            if(seen.contains(num))
                return false;
            seen.add(num);
        }
        
        if(points[0][1]==points[1][1] && points[0][1]==points[2][1])
            return false;
        if((points[0][0]-points[1][0])*(points[0][1]-points[2][1])==
           (points[0][0]-points[2][0])*(points[0][1]-points[1][1]))
            return false;
        return true;
    }
}
