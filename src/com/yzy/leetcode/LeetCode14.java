package com.yzy.leetcode;

/**
 * Description:
 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode14 {

    public static void main(String[] args) {
        String[] input = new String[] {"dog","racecar","car"};
        String res = solution(input);
        System.out.println(res);
    }

    public static String solution(String[] strs) {
        int len = strs.length;
        if (len == 0) return "";
        if (len == 1) return strs[0];
        int minLen = strs[0].length();
        String com = "";
        for (int i = 0; i<len; i ++) {
            minLen = Math.min(minLen, strs[i].length());
        }

        for (int i=0; i<minLen; i++) {
            for (int j=0;j<len - 1;j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) return com;
            }
            com += strs[0].charAt(i);
        }
        return com;
    }

}
