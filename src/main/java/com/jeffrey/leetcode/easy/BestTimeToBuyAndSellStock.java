package com.jeffrey.leetcode.easy;

public class BestTimeToBuyAndSellStock {

	/*
	 * Problem: 121. Best Time to Buy and Sell Stock
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	 *
	 * Time Complexity: O(N), N = the length of the prices array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int maxProfit(int[] prices) {
		int ans = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > min)
				ans = Math.max(ans, prices[i] - min);
			else
				min = prices[i];
		}
		return ans;
	}
}
