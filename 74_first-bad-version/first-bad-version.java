/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/first-bad-version
@Language: Java
@Datetime: 16-08-21 18:08
*/

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        if (n == 0) return -1;
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (!SVNRepo.isBadVersion(mid)) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        return SVNRepo.isBadVersion(start) ? start : end;
    }
}
