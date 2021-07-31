package com.jeffrey.leetcode.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SingleThreadedCPU {

	/*
	 * Problem: 1834. Single-Threaded CPU
	 * https://leetcode.com/problems/single-threaded-cpu/
	 *
	 * Time Complexity: O(NlogN), N = the length of the tasks array
	 *
	 * Space Complexity: O(N)
	 *
	 */

	class Task {
		int id;
		int et;
		int pt;

		public Task(int id, int et, int pt) {
			this.id = id;
			this.et = et;
			this.pt = pt;
		}
	}

	public int[] getOrder(int[][] tasks) {
		int now = -1;
		LinkedList<Task> tq = new LinkedList<Task>();
		for (int i = 0; i < tasks.length; i++) {
			tq.add(new Task(i, tasks[i][0], tasks[i][1]));
		}
		Collections.sort(tq, (t1, t2) -> t1.et - t2.et);
		PriorityQueue<Task> wq = new PriorityQueue<Task>((t1, t2) -> t1.pt == t2.pt ? t1.id - t2.id : t1.pt - t2.pt);

		int[] ans = new int[tasks.length];
		int idx = 0;
		// add all tasks in the task queue which enqueueTime < now into waiting queue
		// choose the one with the shortest processing time from waiting queue
		while (tq.size() > 0) {
			while (tq.size() > 0 && tq.peek().et <= now) {
				wq.add(tq.poll());
			}
			if (wq.size() == 0) {
				now = tq.peek().et;
			} else {
				Task t = wq.poll();
				ans[idx++] = t.id;
				now += t.pt;
			}
		}
		while (wq.size() > 0) {
			ans[idx++] = wq.poll().id;
		}
		return ans;
	}
}
