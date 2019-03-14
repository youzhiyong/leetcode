package com.yzy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 示例 1:

 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5
 示例 2:

 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 输出: 4
 说明:

 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode215 {

    public static void main(String[] args) {

        int[] nums = new int[] {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int exist = solution(nums, k);
        System.out.println(exist);

    }

    public static int solution(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) return nums[0];
        for (int i = 0; i < len; i++) {
            for (int j=i + 1; j<len; j++) {
                if (nums[i] < nums[j]) {
                    //i 和 j 换
                    nums[i] = nums[i] ^ nums[j];
                    nums[j] = nums[i] ^ nums[j];
                    nums[i] = nums[i] ^ nums[j];
                }
            }
            if (i == k - 1) return nums[i];
        }
        return 0;
    }

    // 重复的元素不计算
    public static int solution2(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) return nums[0];
        for (int i = 0; i < len; i++) {
            for (int j=i + 1; j<len; j++) {
                if (nums[i] < nums[j]) {
                    //i 和 j 换
                    nums[i] = nums[i] ^ nums[j];
                    nums[j] = nums[i] ^ nums[j];
                    nums[i] = nums[i] ^ nums[j];
                } else if (nums[i] == nums[j]) {
                    //j 和 最后一个元素 换  把相同的放后面去
                    nums[len - 1] = nums[len - 1] ^ nums[j];
                    nums[j] = nums[len - 1] ^ nums[j];
                    nums[len - 1] = nums[len - 1] ^ nums[j];
                    len--;  //后面的不在判断
                    j--;    //继续从j开始判断
                }
            }
            if (i == k - 1) return nums[i];
        }
        return 0;
    }


}
