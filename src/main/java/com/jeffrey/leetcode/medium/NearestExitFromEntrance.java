package com.jeffrey.leetcode.medium;

import java.util.LinkedList;

public class NearestExitFromEntrance {

	/*
	 * Problem: 1926. Nearest Exit from Entrance in Maze
	 * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
	 *
	 * Time Complexity: O(M*N), M = the row number of maze, N = the column number of
	 * maze
	 *
	 * Space Complexity: O(M+N)
	 *
	 */
	public int nearestExit(char[][] maze, int[] entrance) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		q.offer(entrance);
		int move = 0;
		while (q.size() > 0) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				int[] n = q.poll();

				if (n[0] < 0 || n[0] >= maze.length || n[1] < 0 || n[1] >= maze[0].length || maze[n[0]][n[1]] == '+')
					continue;
				if ((n[0] == 0 || n[1] == 0 || n[0] == maze.length - 1 || n[1] == maze[0].length - 1) && move > 0)
					return move;
				maze[n[0]][n[1]] = '+';
				q.offer(new int[] { n[0] + 1, n[1] });
				q.offer(new int[] { n[0] - 1, n[1] });
				q.offer(new int[] { n[0], n[1] + 1 });
				q.offer(new int[] { n[0], n[1] - 1 });
			}
			move++;
		}
		return -1;
	}
}
