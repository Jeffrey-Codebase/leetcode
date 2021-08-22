package com.jeffrey.leetcode.medium;

import java.util.Arrays;

public class BagOfTokens {

	/*
	 * Problem: 948. Bag of Tokens
	 * https://leetcode.com/problems/bag-of-tokens/
	 *
	 * Time Complexity: O(NlogN), N = the length of the tokens array
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        if(tokens.length==0 || power<tokens[0]) return 0;
        int score=0;
        int i=0,j=tokens.length-1;
        while(i<=j){
            if(power>=tokens[i]){
                power -= tokens[i++];
                score++;
            }else if(j>i){
                power += tokens[j--];
                score--;
            }else{
                break;
            }
        }
        return score;
    }
}
