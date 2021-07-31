package com.jeffrey.leetcode.easy;

public class CanPlaceFlowers {

	/*
	 * Problem: 605. Can Place Flowers
	 * https://leetcode.com/problems/can-place-flowers/
	 *
	 * Time Complexity: O(N), N = the length of the flowerbed array
	 *
	 * Space Complexity: O(1)
	 *
	 */

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (flowerbed.length == 1)
			return n == 0 || (n == 1 && flowerbed[0] == 0);
		if (flowerbed[0] == 0 && flowerbed[1] == 0) {
			n--;
			flowerbed[0] = 1;
		}
		if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
			n--;
			flowerbed[flowerbed.length - 1] = 1;
		}
		for (int i = 1; i < flowerbed.length - 1 && n > 0; i++) {
			if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
				n--;
				flowerbed[i] = 1;
			}
		}
		return n <= 0;
	}
}
