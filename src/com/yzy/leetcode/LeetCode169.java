package com.yzy.leetcode;


import java.util.Arrays;

/**
 * Description:
 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在众数。

 示例 1:

 输入: [3,2,3]
 输出: 3
 示例 2:

 输入: [2,2,1,1,1,2,2]
 输出: 2

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode169 {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2, 3, 1};
        int res = solution(nums);
        System.out.println(res);
    }

    public static int solution(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


}
