package com.jeffrey.leetcode.easy;

public class ReverseInteger {

	/*
	 * Problem: 7. Reverse Integer 
	 * https://leetcode.com/problems/reverse-integer/
	 *
	 * Time Complexity: O(N), N = the length of the input x
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public int reverse(int x) {
		if (x < 10 && x > -10)
			return x;
		char[] max = String.valueOf(Integer.MAX_VALUE).toCharArray();
		char[] min = String.valueOf(Integer.MIN_VALUE).toCharArray();
		char[] xc = String.valueOf(x).toCharArray();
		int index = xc.length - 1;
		while (index >= 0 && xc[index] == '0') {
			index--;
		}
		int L = index + 1;
		if (x < 0 && L == min.length) {
			for (int i = 1; i < min.length; i++) {
				if (xc[L - i] < min[i])
					break;
				if (xc[L - i] > min[i])
					return 0;
			}
		} else if (x > 0 && L == max.length) {
			for (int i = 0; i < max.length; i++) {
				if (xc[L - i - 1] < max[i])
					break;
				if (xc[L - i - 1] > max[i])
					return 0;
			}

		}
		StringBuffer sb = new StringBuffer();
		while (index > 0)
			sb.append(xc[index--]);
		if (x > 0) {
			sb.append(xc[0]);
			return Integer.valueOf(sb.toString());
		} else {
			return -Integer.valueOf(sb.toString());
		}

	}
}
