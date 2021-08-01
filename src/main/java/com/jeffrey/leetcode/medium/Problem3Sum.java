package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem3Sum {

	/*
	 * Problem: 15. 3Sum
	 * https://leetcode.com/problems/3sum/
	 *
	 * Time Complexity: O(N^2), N = the length of the nums array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i = 0;i <nums.length-2&&nums[i]<=0;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int target = -nums[i];
            Set<Integer> seen= new HashSet<Integer>();           
            for(int j=i+1;j<nums.length;j++){    
                int num = target - nums[j];
                if(seen.contains(num)){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(num);
                    list.add(nums[j]);
                    ans.add(list);
                    while (j + 1 < nums.length && nums[j] == nums[j + 1])
                        ++j;
                   
                }
                seen.add(nums[j]);
                
            }
        }
        return ans;
    }
}
