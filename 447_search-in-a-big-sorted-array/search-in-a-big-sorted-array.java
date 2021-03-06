/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/search-in-a-big-sorted-array
@Language: Java
@Datetime: 16-08-21 18:26
*/

/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        if (reader == null) return -1;
        if (reader.get(0) == target) return 0;
        int end = 1;
        while (reader.get(end) < target) {
            end = end * 2;
        }
        int start = end / 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == Integer.MAX_VALUE) {
                end = mid;
                continue;
            }
            if (reader.get(mid) < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (reader.get(start) == target) return start;
        else if (reader.get(end) == target) return end;
        else return -1;
    }
}