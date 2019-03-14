package com.yzy.leetcode;


import com.yzy.common.ListNode;

import java.util.Stack;

/**
 * Description:
 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

 push(x) -- 将元素 x 推入栈中。
 pop() -- 删除栈顶的元素。
 top() -- 获取栈顶元素。
 getMin() -- 检索栈中的最小元素。
 示例:

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> 返回 -3.
 minStack.pop();
 minStack.top();      --> 返回 0.
 minStack.getMin();   --> 返回 -2.

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode155 {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }

    /**
     * 思路：每次入栈2个元素，一个是入栈的元素本身，一个是当前栈元素的最小值
     * 如：入栈序列为2-3-1，则入栈后栈中元素序列为：2-2-3-2-1-1 * 用空间代价来换取时间代价
     */
    static class MinStack {

        /** initialize your data structure here. */
        Stack<Integer> stack;
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.empty()) {
                stack.push(x);
                stack.push(x);
            } else {
                int min = stack.peek();
                stack.push(x);
                if (x < min) {
                    stack.push(x);
                } else {
                    stack.push(min);
                }
            }
        }

        public void pop() {
            stack.pop();
            stack.pop();
        }

        public int top() {
            return stack.get(stack.size() - 2);
        }

        public int getMin() {
            return stack.peek();
        }
    }

}
