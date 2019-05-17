package com.yzy.leetcode;

import java.util.Arrays;

/**
 * Description:
 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 示例 1:
 输入: [2,2,1]
 输出: 1

 示例 2:
 输入: [4,1,2,1,2]
 输出: 4

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode136 {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2, 3, 2};
        int res = solution(nums);
        System.out.println(res);
    }

    //位运算的妙用 异或运算特性：整数n与自己异或的结果为0, 0与整数n异或的结果为n
    public static int solution(int[] nums) {
        int n = 0;
        for (int i : nums) {
            n ^= i;
        }
        return n;
    }


}
