package com.yzy.leetcode;

import java.util.*;

/**
 * Description:
 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

 示例:

 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 输出:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 说明：

 所有输入均为小写字母。
 不考虑答案输出的顺序。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode49 {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> head = solution(strs);
        System.out.println(head);
    }

    public static List<List<String>> solution(String[] strs) {
        if (strs == null) return null;

        //K为排序字符串，value为原值组成的列表
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // 1. 对str 字符串进行排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            // 2. 若排序后的字符串在map的key中，则将原值添加到对应的列表中
            if (map.containsKey(key)) {
                List<String> values = map.get(key);
                values.add(str);
            } else {
                // 3. 若不在map的key中，则新增
                List<String> values = new ArrayList<>();
                values.add(str);
                map.put(key, values);
            }
        }

        return new ArrayList<>(map.values());
    }

}
