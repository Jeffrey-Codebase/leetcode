package com.jeffrey.leetcode.medium;

public class FourDivisors {
	
	/*
	 * Problem: 1390. Four Divisors
	 * https://leetcode.com/problems/four-divisors/
	 *
	 * Time Complexity: O( N * sqrt(N) ), N = the length of the nums array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int sumFourDivisors(int[] nums) {
        int ans = 0;
        int[] cache = new int[100001];
        for(int n : nums){
            if(cache[n]>0)
                ans += cache[n];
            else if(cache[n]==0){
                int cnt = 0;
                int sum = 0;
                for(int i=2;i<=n/i;i++){
                    if(n%i==0){
                        cnt += (i==n/i ? 1 : 2);
                        if(cnt==2)
                            sum = i + n/i;
                        else
                            break;
                    }
                }
                if(cnt==2){
                    cache[n] = sum+1+n;
                    ans += cache[n] ;
                }else{
                    cache[n] = -1;
                }
            }
        }
        return ans;
    }
}
