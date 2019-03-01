package com.yzy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
 示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode07 {

    public static void main(String[] args) {
        int input = 123;
        int res = solution(input);
        System.out.println(res);
    }

    public static int solution(int x) {
        int a = x;
        if (a > -10 && a < 10) {
            return a;
        } else if (a < 0) {
            a = -a;
        }
        long sum = 0;
        while (a > 0) {
            sum = sum * 10 + a % 10;
            a /= 10;
        }
        if (sum < 0) return 0;
        return x < 0 ? -sum < Integer.MIN_VALUE ? 0 : -(int)sum : sum > Integer.MAX_VALUE ? 0 : (int) sum;
    }

}
