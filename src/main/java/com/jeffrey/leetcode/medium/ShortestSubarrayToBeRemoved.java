package com.jeffrey.leetcode.medium;

public class ShortestSubarrayToBeRemoved {

	/*
	 * Problem: 1574. Shortest Subarray to be Removed to Make Array Sorted
	 * https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-
	 * sorted/
	 *
	 * Time Complexity: O(NlogN), N = the length of the tasks array
	 *
	 * Space Complexity: O(N)
	 *
	 */

	public int findLengthOfShortestSubarray(int[] arr) {
		int i = 0, j = arr.length - 1;
		while (i < arr.length - 1 && arr[i] <= arr[i + 1])
			i++;
		if (i == arr.length - 1)
			return 0;
		while (j > 0 && arr[j] >= arr[j - 1])
			j--;
		if (arr[j] >= arr[i])
			return j - i - 1;

		// retrieve the lower in oder part and upper in order part from the input array
		// try to merge two part to get the longest in order array
		int ans = Math.min(j, arr.length - i - 1);
		int left = 0;
		while (left <= i && j < arr.length) {
			if (arr[left] > arr[j])
				j++;
			else {
				ans = Math.min(ans, j - left - 1);
				left++;
			}

		}
		return ans;
	}
}
