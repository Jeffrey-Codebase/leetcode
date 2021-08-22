package com.jeffrey.leetcode.medium;

public class MinimumInsertionsToBalance {

	/*
	 * Problem: 1541. Minimum Insertions to Balance a Parentheses String
	 * https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
	 *
	 * Time Complexity: O(N), N = the length of the s string
	 *
	 * Space Complexity: O(1) 
	 *
	 */
	public int minInsertions(String s) {
        int ans = 0;
        int openCnt=0;
        int closeCnt=0;
        for(char c : s.toCharArray()){
            if(c=='('){
                if(closeCnt==1){             
                    closeCnt--;
                    
                    if(openCnt==0) // handle the case "NaN, ), ("
                        ans += 2;
                    else{	       // handle the case "(, ), ("
                        openCnt--;
                        ans += 1;
                    }
                }
                openCnt++;
            }else{
            	// handle the case "(, )" 
                if(closeCnt==0)
                   closeCnt++;
                else{
                   closeCnt--;
                   if(openCnt==0) // handle the case "NaN, ), )" 
                       ans += 1;
                   else		      // handle the case "(, ), )" 
                       openCnt--;
                }
            }
        }
        if(closeCnt==1){
            if(openCnt==0)
                ans+=2;
            else{
                openCnt--;
                ans+=1;
            }
        }
        return ans + openCnt*2;
    }
}
