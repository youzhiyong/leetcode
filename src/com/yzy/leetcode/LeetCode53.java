package com.yzy.leetcode;

import java.util.Map;

/**
 * Description:

 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例:

 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 进阶:

 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode53 {

    public static void main(String[] args) {
        int[] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        int head = solution1(input);
        System.out.println(head);
    }

    //暴力法
    public static int solution(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i=0; i<nums.length - 1; i++) {
            sum = nums[i];
            for (int j=i + 1; j<nums.length; j++) {
                sum += nums[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    // 假设sum<=0，那么后面的子序列肯定不包含目前的子序列，所以令sum = num；
    // 如果sum > 0对于后面的子序列是有好处的 则相加
    // res = Math.max(res, sum)保证可以找到最大的子序和
    public static int solution1(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i : nums) {
            if (sum > 0)
                sum += i;
            else
                sum = i;
            max = Math.max(sum, max);
        }
        return max;
    }

}
