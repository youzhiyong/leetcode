package com.yzy.leetcode;

/**
 * Description:
 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

 你可以假设数组中无重复元素。

 示例 1:

 输入: [1,3,5,6], 5
 输出: 2
 示例 2:

 输入: [1,3,5,6], 2
 输出: 1
 示例 3:

 输入: [1,3,5,6], 7
 输出: 4
 示例 4:

 输入: [1,3,5,6], 0
 输出: 0
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode35 {

    public static void main(String[] args) {
        int[] input = new int[]{1,3,5,6};

        int head = solution(input, 0);
        System.out.println(head);
    }

    //二分查找法
    public static int solution(int[] nums, int target) {
        int low = 0;
        int height = nums.length - 1;
        int mid = 0;
        while (low <= height) {
            mid = (height + low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                height = mid - 1;
            }
        }
        if (nums[mid] > target) return mid;
        else return mid + 1;
    }

}
