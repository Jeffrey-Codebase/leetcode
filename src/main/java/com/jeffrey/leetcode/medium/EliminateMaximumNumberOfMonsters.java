package com.jeffrey.leetcode.medium;

public class EliminateMaximumNumberOfMonsters {

	/*
	 * Problem: 1921. Eliminate Maximum Number of Monsters
	 * https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
	 *
	 * Time Complexity: O(N), N = the length of the dist array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public int eliminateMaximum(int[] dist, int[] speed) {
		/*
		 * Count the number of the monster arrived at each timestamp t. We are able to
		 * kill t monster before timestamp t and we only have n monsters, so we don't
		 * need to worry about the monster arrived after timestamp n.
		 */
		int[] cnt = new int[dist.length];
		for (int i = 0; i < dist.length; i++) {
			int arriveTime = (int) Math.ceil((double) dist[i] / speed[i]);
			if (arriveTime < dist.length)
				cnt[arriveTime]++;
		}

		/*
		 * We are able to kill t monsters before timestamp t, If the total arrived
		 * monsters more than t, we fail the game.
		 */
		int monster = 0;
		for (int i = 1; i < dist.length; i++) {
			monster += cnt[i];
			if (monster > i)
				return i;
		}
		return dist.length;
	}
}
