package com.jeffrey.leetcode.medium;

import java.util.LinkedList;

/*
 * Problem: 901. Online Stock Span
 * https://leetcode.com/problems/online-stock-span/
 *
 * Time Complexity: O(N), N = the number of the next function call
 *
 * Space Complexity: O(N)
 *
 */

class StockSpanner {
	LinkedList<int[]> q;
	int time = 0;

	public StockSpanner() {
		q = new LinkedList<int[]>();
		q.offer(new int[] { Integer.MAX_VALUE, -1 });
	}

	public int next(int price) {
		while (q.peekLast()[0] <= price)
			q.pollLast();
		int ans = time - q.peekLast()[1];
		q.offer(new int[] { price, time++ });
		return ans;
	}
}

public class OnlineStockSpan {

}
