package com.yzy.leetcode;

/**
 * Description:
 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

 你可以假设 nums1 和 nums2 不会同时为空。

 示例 1:
 nums1 = [1, 3]
 nums2 = [2]

 则中位数是 2.0

 示例 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 则中位数是 (2 + 3)/2 = 2.5
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode04 {

    public static void main(String[] args) {
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        int i = solution(num1, num2);
        System.out.println(i);
    }

    public static int solution(int[] nums1, int[] nums2) {
        int mid = (nums1.length + nums2.length)/2 + 1;




        return 0;
    }

}
