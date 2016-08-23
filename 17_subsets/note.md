```
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Markdown
@Datetime: 16-08-11 07:11
```

我。。。深深的无语与无力。。这道题。。。百转千回。。。竟然做了那么久。。。。。。

根本不会发生重复元素的问题。。。。

根本不需要HashSet来解决重复元素的问题。。。。

对象的定义是以跟着接口走。。。然后这其实在这道题里也不重要。。。

对象的赋值是地址的值传递。。。因此需要在循环里new一个set。。好吧这跟值传递和引用传递有些关系。。

补了一堆周边知识。。comparator，comparatable, ternary operator, HashSet, Java Pass by Value。。。生生把这道题从两小时做成了两天。。。然并卵。。我看你这些东西能记得几天。。。

Arrays.sort(), Collections.sort()，Java的自带对象有很多都自带sort。。。对了。。自带的sort是升序。。

HashSet的底层是Set，本质是无序，偶尔输出有了顺序，证明不了什么。。好吧这跟这道题没啥关系。。。

你的审题再一次完美漏掉了distinct integer这么大的字。。。

Integer中的value是final，所以值传递以后value还是不变。。。好吧这也跟本题没什么关系。。。

我想说按照你这样做一道题引申10个无关项，这些题刷到你退休也刷不完。。关键是引申10项，你能记住几项？？？

本题的思路是循环套循环，外层就是遍历数组，内层遍历已有的set（初始为一个空集），每次将外层循环中的元素加到每一个内层set中（新建），并将这些新建的set在内层循环结束后加到主set中。。。不会有重复。。只要注意好tmp的位置。。。。会有一些对象赋值的小问题。。。不过动脑子也能解。。。。你花了那么长时间。。。。我真的，真的，真的，真的，真的，真的，很无语。
