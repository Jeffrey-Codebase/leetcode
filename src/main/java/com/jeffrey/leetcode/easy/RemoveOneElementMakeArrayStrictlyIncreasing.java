package com.jeffrey.leetcode.easy;

public class RemoveOneElementMakeArrayStrictlyIncreasing {
	
	/*
	 * Problem: 1909. Remove One Element to Make the Array Strictly Increasing
	 * https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
	 *
	 * Time Complexity: O(N), N = the length of nums array
	 *
	 * Space Complexity: O(1)
	 *
	 */

	
	public boolean canBeIncreasing(int[] nums) {
        int left = 0;
        while(left<nums.length-1 && nums[left]<nums[left+1])
            left++;
        int right = nums.length-1;
        if(left==right) 
            return true;
        while(right>0 && nums[right]>nums[right-1])
            right--;
        return left+1==right && (left==0 || right==nums.length-1 || nums[left]<nums[right+1] || nums[left-1]<nums[right]);
    }

}
