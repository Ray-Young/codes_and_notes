```
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array
@Language: Markdown
@Datetime: 16-06-13 11:55
```

 while(lo&lt;=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%n;
            if(A[realmid]==target)return realmid;
            if(A[realmid]&lt;target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
		
		
		 my understanding: when do binary search, we only care about the two boundary indices and the element value in the middle. In this case, though the array is not in sorted order, but we can get the middle-element value with mapping relationship (mid+rot)%n , all left are just same.
		 
		 Leetcode上看到的一个没有看懂的解
		 
		 
		另外，int high = target > A[A.length -1] ? min - 1 : A.length - 1; 数组不会out of bound，因为如果取min - 1，说明数组肯定被旋转，且最小元素不在第一位，那么min-1不会out of bound。