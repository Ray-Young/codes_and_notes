```
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/remove-nth-node-from-end-of-list
@Language: Markdown
@Datetime: 16-07-08 05:34
```

本题有两种做法（不用计算长度）
1. 采用stack，利用先进后出的机制，完美
2. 标准答案的做法。就是先将指针移到n，然后再从头指针开始移动l-n个位置，这样就到了倒数第n位

无论哪种做法，链表的删除必须使用dummy头，俗话说用了dummy头，管你删第一位还是最后一位，都没事，dummy头和dp序列问题必须设个头很相似，情况多种多样，但设头就能简化很多。