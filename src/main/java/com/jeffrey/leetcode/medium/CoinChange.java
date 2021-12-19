package com.jeffrey.leetcode.medium;

import java.util.Arrays;

public class CoinChange {

	
	/*
	 * Problem: 322. Coin Change
	 * https://leetcode.com/problems/coin-change/
	 *
	 * Time Complexity: O(C*N), C = the length of the coins array
	 *
	 * Space Complexity: O(N)
	 *
	 */
	public int coinChange(int[] coins, int N) {
        if(N==0) return 0;
        int[] dp = new int[N+1];
        Arrays.fill(dp, N+1);
        for(int c : coins){
            if(c<=N)
                dp[c]=1;
        }
        for(int i=2;i<=N;i++){
            int min = N;
            for(int c : coins){
                if((i-c)>=0){
                    dp[i] = Math.min(dp[i], dp[i-c]+1);
                }
            }          
            
        }
        
        return dp[N] > N ? -1 : dp[N];
    }
}
