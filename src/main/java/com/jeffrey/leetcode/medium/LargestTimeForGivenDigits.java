package com.jeffrey.leetcode.medium;

public class LargestTimeForGivenDigits {

	/*
	 * Problem: 949. Largest Time for Given Digits
	 * https://leetcode.com/problems/largest-time-for-given-digits/
	 *
	 * Time Complexity: O(4^2), the input is always 4 digits
	 *
	 * Space Complexity: O(1)
	 *
	 */

	public String largestTimeFromDigits(int[] arr) {
		int hour = -1;
		int min = -1;

		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				int h1 = arr[i] * 10 + arr[j];
				if (h1 > 23)
					h1 = -1;
				int h2 = arr[j] * 10 + arr[i];
				if (h2 > 23)
					h2 = -1;
				if (h2 > h1)
					h1 = h2;
				if (h1 > hour) {
					int i2 = -1, j2 = -1;
					for (int k = 0; k < 4; k++) {
						if (k != i && k != j) {
							if (i2 == -1)
								i2 = k;
							else
								j2 = k;
						}
					}
					int m1 = arr[i2] * 10 + arr[j2];
					if (m1 > 59)
						m1 = -1;
					int m2 = arr[j2] * 10 + arr[i2];
					if (m2 > 59)
						m2 = -1;
					if (m2 > m1)
						m1 = m2;
					if (m1 == -1)
						continue;
					hour = h1;
					min = m1;

				}
			}
		}
		if (hour == -1)
			return "";

		StringBuilder sb = new StringBuilder();
		if (hour < 10)
			sb.append(0);
		sb.append(hour);
		sb.append(":");
		if (min < 10)
			sb.append(0);
		sb.append(min);
		return sb.toString();
	}
}
