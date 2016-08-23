```
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/find-peak-element
@Language: Markdown
@Datetime: 16-08-21 17:58
```

mid+1是否存在溢出现象 不会
如果只有一位，则不会进循环，直接跳出
如果有两位或两位以上，则最后循环结束的结果一定是[low/mid],[high]。所以mid+1不会溢出，这是采用这种二分法的一个特点。

对于规则A0&lt;A1, An-1 &gt;An，我们可以推论这之间一定会有一个peak元素，推论可以用折线图理解，数学证明的方法我没有找到。

在上述结论成立的基础上(invariant，好吧，学术一点这个情况基本用这个词），通过归纳法可以得出，只要满足这一条件的任何一段间隔中，都会有peak。因此可以通过二分法的mid元素，如果[mid] &gt; [mid+1]，则说明[low,mid]这一段一定有peak，如果[mid]&lt;=[mid+1],则说明[mid+1, high]这一段一定有peak

通过这个方法二分循环，就能找出最终的某个peak

二刷 8.21