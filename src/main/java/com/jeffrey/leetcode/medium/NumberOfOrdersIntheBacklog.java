package com.jeffrey.leetcode.medium;

import java.util.PriorityQueue;

public class NumberOfOrdersIntheBacklog {

	/*
	 * Problem: 1801. Number of Orders in the Backlog
	 * https://leetcode.com/problems/number-of-orders-in-the-backlog/
	 *
	 * Time Complexity: O(NlogN), N = the length of the orders array
	 *
	 * Space Complexity: O(N)
	 *
	 */

	class Order {
		int price;
		int amount;

		public Order(int p, int a) {
			this.price = p;
			this.amount = a;
		}
	}

	public int getNumberOfBacklogOrders(int[][] orders) {
		PriorityQueue<Order> buy = new PriorityQueue<Order>((o1, o2) -> o2.price - o1.price);
		PriorityQueue<Order> sell = new PriorityQueue<Order>((o1, o2) -> o1.price - o2.price);
		buy.add(new Order(-1, 0));
		sell.add(new Order(Integer.MAX_VALUE, 0));
		for (int[] order : orders) {
			if (order[2] == 0) {
				// handle the buy order, match from existed sell order in the sell queue,
				// if the amount is not enough, add new buy order into buy queue
				while (order[1] > 0 && sell.peek().price <= order[0]) {
					if (sell.peek().amount <= order[1]) {
						order[1] -= sell.poll().amount;
					} else {
						sell.peek().amount -= order[1];
						order[1] = 0;
					}
				}
				if (order[1] > 0)
					buy.add(new Order(order[0], order[1]));
			} else {
				// handle the sell order, match from existed buy order in the buy queue,
				// if the amount is not enough, add new sell order into sell queue
				while (order[1] > 0 && buy.peek().price >= order[0]) {
					if (buy.peek().amount <= order[1]) {
						order[1] -= buy.poll().amount;
					} else {
						buy.peek().amount -= order[1];
						order[1] = 0;
					}
				}
				if (order[1] > 0)
					sell.add(new Order(order[0], order[1]));
			}
		}
		Long ans = 0L;
		while (buy.size() > 0)
			ans += buy.poll().amount;
		while (sell.size() > 0)
			ans += sell.poll().amount;
		ans %= 1000000007;
		return ans.intValue();
	}
}
