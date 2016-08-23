```
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/strstr
@Language: Markdown
@Datetime: 16-07-31 03:59
```

第一次
思路
1. 边界条件 （null和空先判断）
2. 用contains做初选（后续解题的基础，排除伪重合）。增加了时间复杂度，不可取
3. 存在target和tartarget的可能，所以每个字母都要判断
4. 用targetArray[j] != sourceArray[i+j]作为字母判断，target的每个字母每次都要验证，而source每次都会向后移一位

用到的方法
1. toCharArray
2. contains

二刷 这是一道warn up的题，关键是不要做错      7.31
边界：source和target任一为null，则必然是-1。此后，target如果为空，则无论source是什么，都是0.
溢出：如果i+j == source.length，说明已经超出了source的最大长度，要返回