package com.jeffrey.leetcode.medium;

public class FindTwoNonOverlappingSubarrays {

	/*
	 * Problem: 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
	 * https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-
	 * target-sum/
	 *
	 * Time Complexity: O(N), N = the length of the arr array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public int minSumOfLengths(int[] arr, int target) {
		// Record the shortest length of the sub-array with target sum before ith
		// position(itself excluded)
		int[] prefix = new int[arr.length];
		prefix[0] = 1000000;
		int i = 0, j = 1, sum = arr[0];
		while (j < arr.length) {
			while (i < j && sum > target) {
				sum -= arr[i++];
			}
			if (sum == target) {
				prefix[j] = Math.min(prefix[j - 1], j - i);
			} else
				prefix[j] = prefix[j - 1];
			sum += arr[j++];
		}

		// Record the shortest length of the sub-array with target sum after ith
		// position(itself excluded)
		int[] suffix = new int[arr.length];
		suffix[arr.length - 1] = arr[arr.length - 1] == target ? 1 : 1000000;
		i = arr.length - 2;
		j = arr.length - 1;
		sum = arr[arr.length - 1];
		while (i >= 0) {
			sum += arr[i];
			while (j > i && sum > target) {
				sum -= arr[j--];
			}
			if (sum == target) {
				suffix[i] = Math.min(suffix[i + 1], j - i + 1);
			} else
				suffix[i] = suffix[i + 1];
			i--;
		}
		int ans = Integer.MAX_VALUE;
		for (i = 0; i < arr.length; i++) {
			ans = Math.min(ans, prefix[i] + suffix[i]);
		}
		return ans > 100000 ? -1 : ans;
	}
}
