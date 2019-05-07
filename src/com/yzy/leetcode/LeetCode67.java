package com.yzy.leetcode;

/**
 * Description:
 给定两个二进制字符串，返回他们的和（用二进制表示）。

 输入为非空字符串且只包含数字 1 和 0。

 示例 1:

 输入: a = "11", b = "1"
 输出: "100"
 示例 2:

 输入: a = "1010", b = "1011"
 输出: "10101"
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode67 {

    public static void main(String[] args) {
        String a = "11001";
        String b = "1";

        String head = solution(a, b);
        System.out.println(head);
    }

    public static String solution(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        StringBuilder builder = new StringBuilder();
        int len = alen > blen ? alen : blen;
        int flag = 0;
        for (int i=1; i <= len; i++) {
            if (i <= alen && '1' == a.charAt(alen - i)) {
                flag++;
            }
            if (i <= blen && '1' == b.charAt(blen - i)) {
                flag++;
            }
            builder.insert(0, flag % 2);
            if (flag > 1) {
                flag = 1;
            } else {
                flag = 0;
            }

        }
        if (flag == 1) builder.insert(0, 1);
        return builder.toString();
    }

}
