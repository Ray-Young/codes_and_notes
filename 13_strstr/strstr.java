/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/strstr
@Language: Java
@Datetime: 16-07-31 03:59
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) return -1;
        if (target.equals("")) return 0;
        
        for (int i = 0; i < source.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < target.length(); j++) {
                if (i + j == source.length()) {
                    return -1;
                }
                if (source.charAt(i+j) == target.charAt(j)) {
                    flag = true;
                }
                else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}