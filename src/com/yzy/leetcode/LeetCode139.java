package com.yzy.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description:
 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

 说明：

 拆分时可以重复使用字典中的单词。
 你可以假设字典中没有重复的单词。
 示例 1：

 输入: s = "leetcode", wordDict = ["leet", "code"]
 输出: true
 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 示例 2：

 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 输出: true
 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 注意你可以重复使用字典中的单词。
 示例 3：

 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 输出: false

 * Date: 2019-02-27
 *
 * @author youzhiyong
 *
 *
 *

"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]

"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaab"]
 *
 */
public class LeetCode139 {
    public static void main(String[] args) {
        //List<String> list = List.of("cats", "dog", "sand", "and", "cat");
        //boolean res = solution("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", list);
        //System.out.println(res);
    }

    public static boolean solution(String s, List<String> wordDict) {
        boolean flag = check(s, wordDict);
        if (!flag || s.length() > 100) return flag;
        for (String dict: wordDict) {
            if (s.startsWith(dict)) {
                String temp = s.substring(dict.length());
                if (temp.length() == 0) return true;
                if (solution(temp, wordDict)) return true;
            }
        }

        return false;
    }

    public static boolean check(String s, List<String> wordDict) {
        Set set = new HashSet<>();
        for (String dice: wordDict) {
            for (char c : dice.toCharArray()) {
                set.add(c);
            }
        }
        int len = set.size();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size() == len;
    }


}
