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
        int[] num1 = {};
        int[] num2 = {2, 3,4, 4};
        int i = solution(num1, num2);
        System.out.println(i);
    }

    /**
     * 1. 有一个数组为空的情况 判断另一个数组的长度的奇偶性
     * 2. 两个都不为空
     *  遍历获取中间的两个数
     * @param nums1
     * @param nums2
     * @return
     * 执行用时 :6 ms, 在所有 Java 提交中击败了92.98%的用户
     * 内存消耗 :52.1 MB, 在所有 Java 提交中击败了71.56%的用户
     */
    public static int solution(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0) return len2 % 2 == 0 ? ((nums2[len2/2] + nums2[len2/2 -1]) / 2) : nums2[len2/2];
        else if (len2 == 0)return len1 % 2 == 0 ? ((nums1[len1/2] + nums1[len1/2 -1]) / 2) : nums1[len1/2];

        int pre = 0;
        int current = Math.min(nums1[0], nums2[0]);
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i <= ((len1 + len2) / 2); i++) {
            if (i > 0) pre = current;
            if (index1 < len1 && index2 < len2) {
                if (nums1[index1] > nums2[index2]) current = nums2[index2++];
                else current = nums1[index1++];
            } else if (index1 < len1) current = nums1[index1++];
            else current = nums2[index2++];

        }
        return (len1 + len2) % 2 == 0 ? (pre + current) / 2 : current;
    }

}
