package com.jeffrey.leetcode.hard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestSufficientTeam {

	/*
	 * Problem: 1125. Smallest Sufficient Team
	 * https://leetcode.com/problems/smallest-sufficient-team/
	 *
	 * Time Complexity: O(2^N * M + N * M) = O (2^N * M), N = the length of the req_skills array,
	 * 	M = the length of the people list, P = the number of the elements in people list
	 *
	 * Space Complexity: O(2^N * M)
	 *
	 */
	long[][][] dp;
	int[] skillMasks;
	int minTeamSize = Integer.MAX_VALUE;

	public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

		int require = 0;
		for (int i = 0; i < req_skills.length; i++)
			require |= 1 << i;

		dp = new long[require + 1][people.size()][2];
		for (int i = 0; i < require + 1; i++) {
			for (int j = 0; j < people.size(); j++)
				dp[i][j][0] = -1;
		}

		skillMasks = new int[people.size()];
		Map<String, Integer> skillMapping = new HashMap<>();
		int idx = 0;
		for (String s : req_skills) {
			skillMapping.put(s, 1 << (idx++));
		}
		for (int i = 0; i < people.size(); i++) {
			int skillmask = 0;
			for (String skill : people.get(i)) {
				skillmask |= skillMapping.get(skill);
			}
			skillMasks[i] = skillmask;
		}

		long[] team = helper(require, 0, 0);
		int[] ans = new int[(int) team[0]];
		idx = 0;
		for (int i = 0; i < people.size(); i++)
			if (((team[1] >> i) & 1) == 1)
				ans[idx++] = i;
		return ans;
	}

	private long[] helper(int require, int pidx, int teamSize) {

		if (require == 0) {
			minTeamSize = Math.min(minTeamSize, teamSize);
			return new long[] { 0, 0 };
		}
		if (pidx == skillMasks.length || teamSize > minTeamSize)
			return new long[] { Integer.MAX_VALUE, 0 };

		if (dp[require][pidx][0] != -1)
			return dp[require][pidx];

		long[] ans = helper(require, pidx + 1, teamSize);

		if (skillMasks[pidx] > 0) {
			int r = require & ~skillMasks[pidx];
			if (require > r) {
				long[] list = helper(r, pidx + 1, teamSize + 1);
				if (list[0] != Integer.MAX_VALUE && list[0] < ans[0]) {
					ans[0] = list[0] + 1;
					ans[1] = list[1] | (1L << pidx);
				}
			}
		}

		dp[require][pidx] = ans;
		return ans;
	}
}
