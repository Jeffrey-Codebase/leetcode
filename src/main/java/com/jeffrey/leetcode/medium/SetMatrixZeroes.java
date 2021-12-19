package com.jeffrey.leetcode.medium;

public class SetMatrixZeroes {

	/*
	 * Problem: 73. Set Matrix Zeroes
	 * https://leetcode.com/problems/set-matrix-zeroes/
	 *
	 * Time Complexity: O(M*N)
	 *
	 * Space Complexity: O(1)
	 *
	 */
	public void setZeroes(int[][] matrix) {
        boolean r0_0 = false;
        boolean c0_0 = false;
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                r0_0 = true;
                break;
            }
        }
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                c0_0 = true;
                break;
            }
        }
        
        for(int i = 1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
         for(int i = 1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if( matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(r0_0){
            for(int i=0;i<matrix[0].length;i++)
                matrix[0][i]=0;
        }
        if(c0_0){
            for(int i=0;i<matrix.length;i++)
                matrix[i][0]=0;
        }
        
     
    }
}
