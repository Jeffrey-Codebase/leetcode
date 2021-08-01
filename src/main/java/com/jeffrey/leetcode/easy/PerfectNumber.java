package com.jeffrey.leetcode.easy;

public class PerfectNumber {

	/*
	 * Problem: 507. Perfect Number
	 * https://leetcode.com/problems/perfect-number/
	 *
	 * Time Complexity: O(N^0.5), N = the input integer num
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public boolean checkPerfectNumber(int num) {
        int ans =1;
        for(int i = 2;i*i<=num;i++){
            if(i*i==num)
                ans+=i;
            else if (num % i == 0)
                ans += (i+num/i);
        }
        return num==1 ? false : ans == num;
    }
}
