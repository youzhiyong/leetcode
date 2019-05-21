package com.yzy.leetcode;


import java.util.Map;

/**
 * Description:
 给定一个Excel表格中的列名称，返回其相应的列序号。

 例如，

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 ...
 示例 1:

 输入: "A"
 输出: 1
 示例 2:

 输入: "AB"
 输出: 28
 示例 3:

 输入: "ZY"
 输出: 701

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode171 {

    public static void main(String[] args) {
        int res = solution3("AAA");
        System.out.println(res);
    }

    //第一版
    public static int solution(String s) {
        int sum = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(len - 1 - i);
            int n = c - 'A' + 1;
            for (int j = i; j > 0; j--) {
                n *= 26;
            }
            sum += n;
        }
        return sum;
    }

    //提取公式
    public static int solution2(String s) {
        int sum = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            sum += (s.charAt(i) - 'A' + 1) * Math.pow(26, len - i - 1);
        }
        return sum;
    }

    //递归
    public static int solution3(String s) {
        return s.length() == 0 ? 0 : (s.charAt(s.length() - 1) - 'A' + 1 + solution3(s.substring(0, s.length() - 1)) * 26);
    }


}
