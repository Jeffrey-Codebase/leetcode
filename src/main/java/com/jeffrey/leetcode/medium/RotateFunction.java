package com.jeffrey.leetcode.medium;

public class RotateFunction {

	/*
	 * Problem: 396. Rotate Function
	 * https://leetcode.com/problems/rotate-function/
	 *
	 * Time Complexity: O(N), N = the length of the nums array
	 *
	 * Space Complexity: O(1)
	 *
	 */

	public int maxRotateFunction(int[] nums) {
		int sum1 = 0;
		int fun1 = 0;
		for (int i = 0; i < nums.length; i++) {
			sum1 += nums[i];
			fun1 += nums[i] * i;
		}
		int max = fun1;
		int sum2 = 0;
		int fun2 = 0;
		for (int i = nums.length - 1; i > 0; i--) {
			sum1 -= nums[i];
			fun1 -= (nums.length - 1) * nums[i];
			fun1 += sum1;
			fun2 += sum2;
			sum2 += nums[i];
			max = Math.max(max, fun1 + fun2);
		}
		return max;
	}
}
