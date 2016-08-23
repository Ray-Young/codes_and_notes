/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/merge-sorted-array
@Language: Java
@Datetime: 16-08-02 08:07
*/

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // First Version
        // if (A == null) return;
        // if (B == null || n == 0) return;
        // int i = 0, j = 0;
        // for (int z = 0; z < m + n; z++) {
        //     if (A[i] != 0 && A[i] < B[j]) {
        //         i++;
        //     }
        //     else if(A[i] >= B[j]) {
        //         for (int k = m - 1; k >=i; k--) {
        //             A[k+1] = A[k];
        //         }
        //         A[i] = B[j];
        //         m = m + 1;
        //         i++;
        //         j++;
        //     }
        //     if (i > m -1){
        //         for (int c = j; c < n; c++) {
        //             A[i] = B[c];
        //             i++;
        //         }
        //         break;
        //     }
        //     if (j > n - 1) {
        //         break;
        //     }
            
        // }
        
        // Second Version
        int index = m + n;
        
        while (m > 0 && n > 0) {
            if (A[m - 1] < B[n - 1]) {
                A[--index] = B[--n];
            }
            else {
                A[--index] = A[--m];
            }
        }
        while (m > 0) {
            A[--index] = A[--m];
        }
        while (n > 0) {
            A[--index] = B[--n];
        }
    }
}