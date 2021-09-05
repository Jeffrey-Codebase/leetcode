package com.jeffrey.leetcode.medium;

public class KConcatenationMaximumSum {

	/*
	 * Problem: 1191. K-Concatenation Maximum Sum
	 * https://leetcode.com/problems/k-concatenation-maximum-sum/
	 *
	 * Time Complexity: O(N), N = the length of the arr array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int kConcatenationMaxSum(int[] arr, int k) {
		int last = arr.length - 1;
		long maxsubsum = 0;
		long subsum = 0;
		long maxprefix = 0;
		long sum = 0;
		long maxsuffix = 0;
		long suffixsum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			maxprefix = Math.max(maxprefix, sum);
			suffixsum += arr[last - i];
			maxsuffix = Math.max(maxsuffix, suffixsum);
			if (subsum + arr[i] <= 0) {
				subsum = 0;
			} else {
				subsum += arr[i];
				maxsubsum = Math.max(maxsubsum, subsum);
			}
		}
		long ans = Math.max(sum * k, maxsubsum);
		if (k > 1) {
			if (sum < 0)
				sum = 0;
			ans = Math.max(ans, maxprefix + maxsuffix + sum * (k - 2));
		}
		return (int) (ans % 1000000007);

	}
}
