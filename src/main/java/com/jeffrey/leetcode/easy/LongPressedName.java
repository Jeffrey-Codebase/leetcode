package com.jeffrey.leetcode.easy;

public class LongPressedName {

	/*
	 * Problem: 925. Long Pressed Name
	 * https://leetcode.com/problems/long-pressed-name/
	 *
	 * Time Complexity: O(N), N = the length of the typed string
	 *
	 * Space Complexity: O(1)
	 *
	 */

	public boolean isLongPressedName(String name, String typed) {
		if (name.charAt(0) != typed.charAt(0) || typed.length() < name.length())
			return false;
		int j = 1;
		int i = 1;
		for (; i < name.length() && j < typed.length(); i++) {
			if (name.charAt(i) == typed.charAt(j)) {
				j++;
			} else {
				while (j < typed.length() && typed.charAt(j) == typed.charAt(j - 1))
					j++;
				if (j == typed.length() || name.charAt(i) != typed.charAt(j))
					return false;
				j++;
			}

		}
		while (j < typed.length() && typed.charAt(j) == typed.charAt(j - 1))
			j++;

		return i == name.length() && j == typed.length();
	}
}
