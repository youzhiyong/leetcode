package com.yzy.leetcode;

import java.util.*;

/**
 * Description:
 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:
 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 示例 2:
 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

 示例 3:
 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode03 {
    public static void main(String[] args) {
        String input = "abcabcbb";
        int res = solution(input);
        System.out.println(res);
    }

    public static int solution(String s) {
        List<Character> values = new ArrayList<>();  //最新 子串列表
        List<Integer> indexs = new ArrayList<>();    //子串元素对应在原始字符串中的位置
        int maxLen = 0;  //最大长度
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (values.contains(ch)) {
                i = indexs.get(values.indexOf(ch)); // 将循环指针切换到第一个重复的元素位置
                maxLen = maxLen >= values.size() ? maxLen : values.size();
                values.clear();
                indexs.clear();
            } else {
                values.add(ch);
                indexs.add(i);
                maxLen = maxLen >= values.size() ? maxLen : values.size();
            }
        }
        return maxLen;
    }
}
