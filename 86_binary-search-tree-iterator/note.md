```
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/binary-search-tree-iterator
@Language: Markdown
@Datetime: 16-06-25 12:11
```

用ArrayList   时间复杂度是1，空间复杂度是n

用stack，空间复杂度是O(h)，时间复杂度的平均值是O(n)，但它run average是O(1)，思路是用一个函数先从root到所有右子节点用while放入stack，每次next的时候，先pop出stack的第一个节点，再将这个节点的第一个右节点和第一个右节点的所有左节点都push到stack中（这种push的方式就是inorder）