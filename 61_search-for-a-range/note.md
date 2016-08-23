```
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/search-for-a-range
@Language: Markdown
@Datetime: 16-06-13 12:51
```

if (target == A[high] && target == A[low]) return low;
if (target == A[high] && target == A[low]) return high;

添加这两条验证来验证全数列相等的特殊情况。

