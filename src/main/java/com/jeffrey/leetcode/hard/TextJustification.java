package com.jeffrey.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	/*
	 * Problem: 68. Text Justification
	 * https://leetcode.com/problems/text-justification/
	 *
	 * Time Complexity: O(N*W), N = the length of the words array, W = maxWidth
	 *
	 * Space Complexity: O(N*W)
	 *
	 */
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> ans = new ArrayList<String>();
		List<String> line = new ArrayList<String>();
		int len = -1;
		for (int i = 0; i < words.length; i++) {
			if (len + 1 + words[i].length() <= maxWidth) {
				line.add(words[i]);
				len += (1 + words[i].length());
			} else {
				ans.add(oneLine(line, maxWidth));
				line.clear();
				line.add(words[i]);
				len = words[i].length();
			}
		}
		StringBuilder last = new StringBuilder();
		for (int i = 0; i < line.size(); i++) {
			last.append(line.get(i));
			if (i != line.size() - 1)
				last.append(" ");
		}
		while (last.length() < maxWidth)
			last.append(" ");
		ans.add(last.toString());
		return ans;
	}

	private String oneLine(List<String> list, int w) {
		StringBuilder sb = new StringBuilder();
		sb.append(list.get(0));
		if (list.size() == 1) {
			while (sb.length() < w)
				sb.append(" ");
			return sb.toString();
		}
		int len = 0;
		for (int i = 0; i < list.size(); i++) {
			len += list.get(i).length();
		}
		int avg = (w - len) / (list.size() - 1);
		int extra = (w - len) % (list.size() - 1);
		StringBuilder space = new StringBuilder();
		for (int i = 0; i < avg; i++) {
			space.append(" ");
		}
		for (int i = 1; i < list.size(); i++) {
			sb.append(space);
			if (extra-- > 0)
				sb.append(" ");
			sb.append(list.get(i));
		}
		return sb.toString();
	}
}
