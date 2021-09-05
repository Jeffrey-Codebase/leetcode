package com.jeffrey.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInAnArray {

	/*
	 * Problem: 1814. Count Nice Pairs in an Array
	 * https://leetcode.com/problems/count-nice-pairs-in-an-array/
	 *
	 * Time Complexity: O(N*M), N = the length of the nums array, M = the max length
	 * of the number in the nums array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public int countNicePairs(int[] nums) {
		long ans = 0;
		Map<Long, Integer> difCnt = new HashMap<Long, Integer>();
		for (int n : nums) {
			long dif = reverseDif(n);
			if (difCnt.containsKey(dif)) {
				int cnt = difCnt.get(dif);
				ans += cnt;
				difCnt.put(dif, cnt + 1);
			} else {
				difCnt.put(dif, 1);
			}

		}
		return (int) (ans % 1000000007);
	}

	private long reverseDif(int num) {
		int n = num;
		long reverse = 0;
		while (n > 9) {
			reverse = reverse * 10 + n % 10;
			n /= 10;
		}
		reverse = reverse * 10 + n;
		return reverse - num;
	}
}
