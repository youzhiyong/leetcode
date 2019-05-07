package com.yzy.leetcode;

import com.yzy.common.ListNode;

/**
 * Description:
 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode88 {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,0,0,0};
        int[] b = new int[]{2,5,6};

        solution(a,3, b, 3);
        System.out.println(a);
    }

    //将两个数组排序的内容放入新数组保存，然后用新数组替换旧数组
    public static void solution(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];
        int p = 0;
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            if (i >= m) {
                temp[p++] = nums2[j++];
            } else if (j >= n) {
                temp[p++] = nums1[i++];
            } else if (nums1[i] >= nums2[j]) {
                temp[p++] = nums2[j++];
            } else {
                temp[p++] = nums1[i++];
            }
        }

        for (int s = 0; s<temp.length;s++) {
            nums1[s] = temp[s];
        }
    }

    //先将数组nums2 追加到 数组num1后面，然后对 num1排序
    public static void solution2(int[] nums1, int m, int[] nums2, int n) {
        //todo
    }



}
