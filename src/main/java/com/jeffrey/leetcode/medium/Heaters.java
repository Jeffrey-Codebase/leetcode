package com.jeffrey.leetcode.medium;

import java.util.Arrays;

public class Heaters {

	/*
	 * Problem: 475. Heaters 
	 * https://leetcode.com/problems/heaters/
	 *
	 * Time Complexity: O(NlogN + MlogM), N = the length of house array, M = the
	 * length of heater array
	 *
	 * Space Complexity: O(1)
	 *
	 */

	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int idx1 = 0, idx2 = 0;
		int ans = 0;
		while (idx1 < houses.length && idx2 < heaters.length) {
			while (idx2 < heaters.length && heaters[idx2] < houses[idx1])
				idx2++;
			int left = idx2 == 0 ? Integer.MAX_VALUE : houses[idx1] - heaters[idx2 - 1];
			int right = idx2 == heaters.length ? Integer.MAX_VALUE : heaters[idx2] - houses[idx1];
			ans = Math.max(ans, Math.min(left, right));
			idx1++;
		}

		if (idx1 < houses.length)
			ans = Math.max(ans, houses[houses.length - 1] - heaters[heaters.length - 1]);
		return ans;
	}
}
