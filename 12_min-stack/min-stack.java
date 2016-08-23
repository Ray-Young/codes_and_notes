/*
@Copyright:LintCode
@Author:   betterme
@Problem:  http://www.lintcode.com/problem/min-stack
@Language: Java
@Datetime: 16-07-17 09:19
*/

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()) minStack.push(number);
        //这一步即保持了minStack与Stack的数量相同，保证了不会在pop时出错，又保证了minStack的头元素一定是最小值
        //如果新入的元素大于min，则再push一个min
        else minStack.push(Math.min(minStack.peek(), number));
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
