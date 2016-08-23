/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/word-ladder
@Language: Java
@Datetime: 16-07-26 12:23
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // 字符串的比较应该用equals函数。习惯第一次用了‘==’
        if (start.equals(end)) return 1;
        
        if (dict == null) return 0;
        
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        //dict.add(start)这句话感觉可以省略
        //dict.add(start);
        dict.add(end);
        
        q.offer(start);
        visited.add(start);
        
        int length = 1;
        String word;
        
        while (!q.isEmpty()) {
            length++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                word = q.poll();
                for (String w : getNextWord(word, dict)) {
                    if (visited.contains(w)) continue;
                    if (w.equals(end)) return length;
                    q.offer(w);
                    visited.add(w);
                }
            }
        }
        return 0;
    }
    
    public ArrayList<String> getNextWord(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<>();
        for (char w = 'a'; w <= 'z'; w++) {
            for (int i = 0; i < word.length(); i++) {
                if (w == word.charAt(i)) continue;
                String nextWord = replaceLetter(i, w, word);
                if (dict.contains(nextWord)) nextWords.add(nextWord);
            }
        }
        return nextWords;
    }
    
    public String replaceLetter(int index, char w, String str) {
        char[] word = str.toCharArray();
        word[index] = w;
        return new String(word);
    }
}