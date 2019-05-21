package com.yzy.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 给定一个正整数，返回它在 Excel 表中相对应的列名称。

 例如，

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 ...
 示例 1:

 输入: 1
 输出: "A"
 示例 2:

 输入: 28
 输出: "AB"
 示例 3:

 输入: 701
 输出: "ZY"

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode168 {

    public static void main(String[] args) {
        String res = solution(229);
        System.out.println(res);
    }

    // 0s 100%
    public static String solution(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            int r = n % 26;
            n /= 26;
            if (r == 0) {
                r = 26;
                n--;
            }
            builder.insert(0, (char) ('A' + r - 1));
        }
        return builder.toString();
    }


}
