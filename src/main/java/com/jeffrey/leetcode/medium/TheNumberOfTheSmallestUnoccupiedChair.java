package com.jeffrey.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TheNumberOfTheSmallestUnoccupiedChair {

	/*
	 * Problem: 1942. The Number of the Smallest Unoccupied Chair
	 * https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/
	 *
	 * Time Complexity: O(NlogN), N = the length of the times array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	class People {
		int id;
		int s;
		int e;
		int chair;

		public People(int id, int s, int e) {
			this.id = id;
			this.s = s;
			this.e = e;
		}
	}

	public int smallestChair(int[][] times, int targetFriend) {
		List<People> people = new ArrayList<People>();
		for (int i = 0; i < times.length; i++) {
			people.add(new People(i, times[i][0], times[i][1]));
		}
		Collections.sort(people, (p1, p2) -> p1.s - p2.s);
		PriorityQueue<People> sit = new PriorityQueue<People>((p1, p2) -> p1.e - p2.e);
		PriorityQueue<Integer> releaseChair = new PriorityQueue<Integer>();
		int chairNum = 0;
		for (People p : people) {
			while (sit.size() > 0 && sit.peek().e <= p.s) {
				releaseChair.add(sit.poll().chair);
			}
			if (releaseChair.size() > 0) {
				p.chair = releaseChair.poll();
			} else {
				p.chair = chairNum++;
			}
			if (p.id == targetFriend)
				return p.chair;
			sit.add(p);
		}
		return -1;
	}
}
