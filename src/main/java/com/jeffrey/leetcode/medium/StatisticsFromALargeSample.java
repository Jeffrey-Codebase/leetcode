package com.jeffrey.leetcode.medium;

public class StatisticsFromALargeSample {

	/*
	 * Problem: 1093. Statistics from a Large Sample
	 * https://leetcode.com/problems/statistics-from-a-large-sample/
	 *
	 * Time Complexity: O(N), N = the length of the count array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public double[] sampleStats(int[] count) {

		int idx = 0;
		while (idx < count.length && count[idx] == 0) {
			idx++;
		}
		int min = idx;
		int max = idx;
		long sum = (long) idx * count[idx];
		int mod = idx;
		int modCnt = count[idx];

		idx++;
		while (idx < count.length) {
			if (count[idx] != 0) {
				max = idx;
				sum += (long) idx * count[idx];

				if (count[idx] > modCnt) {
					mod = idx;
					modCnt = count[idx];
				}
			}
			count[idx] += count[idx - 1];
			idx++;
		}
		// count medium
		int a = (count[count.length - 1] + 1) / 2;
		int b = (count[count.length - 1] + 2) / 2;
		idx = min;
		while (idx < count.length) {
			if (count[idx] >= a) {
				a = idx;
				break;
			}
			idx++;
		}
		while (idx < count.length) {
			if (count[idx] >= b) {
				b = idx;
				break;
			}
			idx++;
		}
		return new double[] { min, max, sum / (double) count[count.length - 1], (a + b) / (double) 2, mod };

	}
}
