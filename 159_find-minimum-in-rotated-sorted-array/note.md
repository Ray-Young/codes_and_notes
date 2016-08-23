```
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array
@Language: Markdown
@Datetime: 16-08-12 10:34
```

Advanced Binary Search.

为什么不用第一个数而用最后一个数。

如果该数组本身就是sorted array，从首元素找起，则找不到这个元素。

二刷：
搞清楚为什么这么写binary search，（不会溢出，不会死循环）