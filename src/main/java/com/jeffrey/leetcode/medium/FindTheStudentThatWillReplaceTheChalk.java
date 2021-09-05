package com.jeffrey.leetcode.medium;

public class FindTheStudentThatWillReplaceTheChalk {

	/*
	 * Problem: 1894. Find the Student that Will Replace the Chalk
	 * https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/
	 *
	 * Time Complexity: O(N), N = the length of the chalk array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int chalkReplacer(int[] chalk, int k) {
		long sum = 0;
		for (int i = 0; i < chalk.length; i++)
			sum += chalk[i];
		if (sum <= k)
			k %= sum;
		for (int i = 0; i < chalk.length; i++) {
			k -= chalk[i];
			if (k < 0)
				return i;
		}
		return -1;
	}

}
