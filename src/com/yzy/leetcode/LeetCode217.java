package com.yzy.leetcode;

import com.yzy.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description:
 给定一个整数数组，判断是否存在重复元素。

 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

 示例 1:

 输入: [1,2,3,1]
 输出: true
 示例 2:

 输入: [1,2,3,4]
 输出: false
 示例 3:

 输入: [1,1,1,3,3,4,3,2,4,2]
 输出: true

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode217 {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 2, 3, 4, 1};
        boolean exist = solution(nums);
        System.out.println(exist);

    }

    //根据set集合元素不重复，add重复元素返回false的特性
    public static boolean solution(int[] nums) {
        if (nums.length < 2) return false;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) return true;
        }
        return false;
    }


}
