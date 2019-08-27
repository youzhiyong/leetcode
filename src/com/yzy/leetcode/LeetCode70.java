package com.yzy.leetcode;

/**
 * Description:
 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 注意：给定 n 是一个正整数。

 示例 1：

 输入： 2
 输出： 2
 解释： 有两种方法可以爬到楼顶。
 1.  1 阶 + 1 阶
 2.  2 阶
 示例 2：

 输入： 3
 输出： 3
 解释： 有三种方法可以爬到楼顶。
 1.  1 阶 + 1 阶 + 1 阶
 2.  1 阶 + 2 阶
 3.  2 阶 + 1 阶


规律
    f(1) = 1
    f(2) = 2
    f(3) = 3
    ...
    f(n) = f(n-1) + f(n-2)   n > 2

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode70 {

    public static void main(String[] args) {
        int a = 5;
        int head = solution2(a);
        System.out.println(head);
    }

    //递归 超时
    public static int solution(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return solution(n - 1) + solution(n - 2);
    }

    //斐波那契数列
    //规律：f(1) = 1, f(2) = 2, f(n) = f(n-1) + f(n-2)
    //迭代
    public static int solution2(int n) {
        if (n <= 0) return 0;
        int pre2 = 1;
        int pre1 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = pre1;
            pre1 += pre2;
            pre2 = temp;
        }

        return pre1;
    }




}
