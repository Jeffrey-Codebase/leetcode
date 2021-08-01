package com.jeffrey.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDifferentIntegers {

	/*
	 * Problem: 1805. Number of Different Integers in a String
	 * https://leetcode.com/problems/number-of-different-integers-in-a-string/
	 *
	 * Time Complexity: O(N), N = the length of the input word string
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public int numDifferentIntegers(String word) {
		Set<String> set = new HashSet<String>();
		StringBuilder sb = new StringBuilder();

		for (char c : word.toCharArray()) {
			if (Character.isDigit(c)) {
				sb.append(c);
			} else {
				if (sb.length() > 0) {
					int s = 0;
					while (s < sb.length() && sb.charAt(s) == '0')
						s++;
					if (s == sb.length())
						set.add("0");
					else
						set.add(sb.substring(s));
					sb.setLength(0);
				}
			}
		}
		if (sb.length() > 0) {
			int s = 0;
			while (s < sb.length() && sb.charAt(s) == '0')
				s++;
			if (s == sb.length())
				set.add("0");
			else
				set.add(sb.substring(s));
			sb.setLength(0);
		}
		return set.size();
	}

}
