package com.yzy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

 示例 1：
 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。

 示例 2：
 输入: "cbbd"
 输出: "bb"

 1. 必须保存第一个自闭环的起始和结束位置
 2. 若有第二个闭环，则第二个闭环的起始位置是前一个闭环的起始位置的后一个 错误！！！  第二个闭环的起始位置需要记录
 3. 比较两个闭环的长度，更新起始和结束位置

 不明白 回文子串 ？？？ 测试不通过
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode05 {

    public static void main(String[] args) {
        String input = "babad";
        String res = solution(input);
        System.out.println(res);
    }

    public static String solution(String s) {
        if (s == null || s.length() < 1) return "";
        Set<Character> set = new HashSet();
        int len = s.length();
        int maxLen = 0, begin = 0, endIndex = 0;  //最大长度,最终起始点，当前起始点，最终结束点
        for (int i=0; i<len; i++) {
            for (int j=i + 1; j<len; j++) {
                if (! set.add(s.charAt(j))) {
                    //内部成环
                    set.clear();
                    break;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (maxLen < j - i) {
                        maxLen = j - i;
                        begin = i;
                        endIndex = j;
                    }
                    if (maxLen >= len - begin) { //如果现有的闭环长度 大于 剩余可能出现的闭环长度
                        return s.substring(begin, endIndex + 1);
                    }
                    break;
                }
                System.out.println("maxLen=" + maxLen + "; begin:" + begin + ";end:" + endIndex + ";i:" + i + ";j:" + j);
            }
        }
        return s.substring(begin, endIndex + 1);

    }

}
