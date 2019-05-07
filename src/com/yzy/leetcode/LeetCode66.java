package com.yzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode66 {

    public static void main(String[] args) {
        int[] input = new int[]{8, 9, 9, 9};

        int[] head = solution(input);
        System.out.println(head);
    }

    public static int[] solution(int[] digits) {
        boolean flag = false;
        digits[digits.length-1] = ++digits[digits.length-1];
        for (int i = digits.length-1; i>=0; i--) {
            int n = digits[i] + (flag ? 1 : 0);
            if (n >= 10) {
                flag = true;
                n -= 10;
            } else {
                flag = false;
            }
            digits[i] = n;
        }
        if (flag) {
            //return new int[]{1, ...digits};
            int[] res = new int[1 + digits.length];
            res[0] = 1;
            for (int i=1; i<res.length; i++) {
                res[i] = digits[i-1];
            }
            return res;
        }
        return digits;
    }

}
