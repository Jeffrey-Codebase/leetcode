package com.jeffrey.leetcode.medium;

public class MaskingPersonalInformation {

	/*
	 * Problem: 831. Masking Personal Information
	 * https://leetcode.com/problems/masking-personal-information/
	 *
	 * Time Complexity: O(N), N = the length of s string
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public String maskPII(String s) {
		if (s.contains("@")) {
			String[] email = s.toLowerCase().split("@");
			StringBuilder sb = new StringBuilder();
			sb.append(email[0].charAt(0));
			sb.append("*****");
			sb.append(email[0].charAt(email[0].length() - 1));
			sb.append('@');
			sb.append(email[1]);
			return sb.toString();
		} else {
			int local = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = s.length() - 1; i >= 0; i--) {
				char c = s.charAt(i);
				if (Character.isDigit(c)) {
					if (local == 4 || local == 7 || local == 10)
						sb.append('-');
					if (local < 4)
						sb.append(c);
					else
						sb.append('*');
					local++;
				}

			}
			if (local > 10)
				sb.append('+');
			return sb.reverse().toString();
		}
	}
}
