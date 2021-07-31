package com.jeffrey.leetcode.medium;

public class MinimumNumberOfFlips {

	/*
	 * Problem: 1888. Minimum Number of Flips to Make the Binary String Alternating
	 * https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
	 *
	 * Time Complexity: O(N), N = the length of String s
	 *
	 * Space Complexity: O(N)
	 *
	 */
	
	//Note what actually matters is how many 0s and 1s are in odd and even positions
	public int minFlips(String s) {
	     
        char[] ca = s.toCharArray();
        int L = s.length();
        int[] odd = new int[2];
        int[] even = new int[2];
        for(int j=0;j<L;j++){
            int idx = j;
         
            if(ca[idx]=='0')
                if(j%2==0)
                    even[0]++;
                else
                    odd[0]++;
            else
                if(j%2==0)
                    even[1]++;
                else
                    odd[1]++;
        }
        int ans = Math.min(odd[1]+even[0],odd[0]+even[1]);
        for(int i=0;i< L-1 ;i++){
            if(ca[i]=='0'){
                even[0]--;
                int[] tmp = odd;
                odd=even;
                even=tmp;
                if(L%2==1)
                    even[0]++;
                else
                    odd[0]++;
            }else{
                even[1]--;
                int[] tmp = odd;
                odd=even;
                even=tmp;
                  if(L%2==1)
                    even[1]++;
                else
                    odd[1]++;
            }
            ans = Math.min(ans, Math.min(odd[1]+even[0],odd[0]+even[1]));
            if(ans ==0) return ans;
            
        }
        return ans;
        
    }
}
