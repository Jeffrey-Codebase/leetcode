package com.jeffrey.leetcode.medium;

public class JumpGame {
	
	/*
	 * Problem: 55. Jump Game
	 * https://leetcode.com/problems/jump-game/
	 *
	 * Time Complexity: O(N), N = the length of the nums array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public boolean canJump(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(i>max)
                return false;
            max = Math.max(max,i+nums[i]);
        }
        return true;
        
    }

}
