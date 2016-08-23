```
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/search-in-a-big-sorted-array
@Language: Markdown
@Datetime: 16-08-21 18:26
```

二刷 8.21
要找第一个元素，还是最后一个元素，关键在于内部if的写法。
举例来说，如果要找第一个元素
就是if (A[mid] < target) start = mid; else end = mid;
如果是最后一个元素，就是if (A[mid] >target) end = mid; else start = mid;
总而言之就是，在等于情况下，是前移还是后移。