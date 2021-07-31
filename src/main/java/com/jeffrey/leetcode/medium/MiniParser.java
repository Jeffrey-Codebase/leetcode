package com.jeffrey.leetcode.medium;

import java.util.LinkedList;

import com.jeffrey.leetcode.builtin.mock.NestedInteger;

public class MiniParser {

	/*
	 * Problem: 385. Mini Parser
	 * https://leetcode.com/problems/mini-parser/
	 *
	 * Time Complexity: O(N), N = the length of the String s
	 *
	 * Space Complexity: O(N)
	 *
	 */


	public NestedInteger deserialize(String s) {
		LinkedList<NestedInteger> stack = new LinkedList<NestedInteger>();
		// NestedInteger num = new NestedInteger();
		stack.push(new NestedInteger());
		int sign = 0;
		int cur = 0;
		for (char c : s.toCharArray()) {
			if (c == '-')
				sign = -1;
			else if (Character.isDigit(c)) {
				cur = cur * 10 + c - '0';
				if (sign == 0)
					sign = 1;
			} else if (c == '[') {
				stack.push(new NestedInteger());
				// num = new NestedInteger();
				sign = 0;
				cur = 0;
			} else if (c == ',') {
				if (sign != 0)
					stack.peek().add(new NestedInteger(sign * cur));
				sign = 0;
				cur = 0;
			} else {
				if (sign != 0)
					stack.peek().add(new NestedInteger(sign * cur));
				NestedInteger i = stack.pop();
				stack.peek().add(i);
				sign = 0;
				cur = 0;
			}
		}
		if (sign != 0)
			stack.peek().add(new NestedInteger(sign * cur));

		return stack.pop().getList().get(0);

	}
}
