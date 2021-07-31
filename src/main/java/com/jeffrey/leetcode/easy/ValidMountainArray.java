package com.jeffrey.leetcode.easy;

public class ValidMountainArray {

	/*
	 * Problem: 941. Valid Mountain Array
	 * https://leetcode.com/problems/valid-mountain-array/
	 *
	 * Time Complexity: O(N), N = the length of the arr array
	 *
	 * Space Complexity: O(1)
	 *
	 */

	public boolean validMountainArray(int[] arr) {
		int left = 0;
		while (left < arr.length - 1 && arr[left] < arr[left + 1])
			left++;
		if (left == arr.length - 1)
			return false;

		int right = arr.length - 1;
		while (right > 0 && arr[right] < arr[right - 1])
			right--;

		return right != 0 && left == right;
	}
}
