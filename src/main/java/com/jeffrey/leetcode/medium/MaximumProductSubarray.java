package com.jeffrey.leetcode.medium;

public class MaximumProductSubarray {
	
	/*
	 * Problem: 152. Maximum Product Subarray
	 * https://leetcode.com/problems/maximum-product-subarray/
	 *
	 * Time Complexity: O(N), N = the length of the nums array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int maxProduct(int[] nums) {
        int ans = nums[0];
        int pos = 1, neg = 0;
        for(int n : nums){
            if(n==0){
                ans = Math.max(ans,0);
                pos = 1;
                neg = 0;
            }else if(n>0){
                pos *= n;     
                neg *= n;
                ans = Math.max(ans,pos);
            }else{
                if(neg == 0){
                    neg = pos*n;
                    pos = 1;
                    ans = Math.max(ans,neg);
                }else{
                    int temp = neg;
                    neg = pos * n;
                    pos = temp*n;
                    ans = Math.max(ans,pos);
                }
            }
        }
        return ans;
    }
}
