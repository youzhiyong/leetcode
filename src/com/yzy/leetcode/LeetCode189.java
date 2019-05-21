package com.yzy.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

 示例 1:

 输入: [1,2,3,4,5,6,7] 和 k = 3
 输出: [5,6,7,1,2,3,4]
 解释:
 向右旋转 1 步: [7,1,2,3,4,5,6]
 向右旋转 2 步: [6,7,1,2,3,4,5]
 向右旋转 3 步: [5,6,7,1,2,3,4]
 示例 2:

 输入: [-1,-100,3,99] 和 k = 2
 输出: [3,99,-1,-100]
 解释:
 向右旋转 1 步: [99,-1,-100,3]
 向右旋转 2 步: [3,99,-1,-100]
 说明:

 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 要求使用空间复杂度为 O(1) 的原地算法。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode189 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution3(nums, 1);
        System.out.println(nums);
    }

    public static void solution(int[] nums, int k) {

        int len = nums.length;
        if (k % len == 0) return;
        int temp = nums[0];
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        while (j < len){
            if (set.add(i)) {
                i = (i + k) % len;
                int n = nums[i];
                nums[i] = temp;
                temp = n;
                j++;
            } else {
                i = (i + 1) % len;
                temp = nums[i];
            }
        }
    }

    public static void solution2(int[] nums, int k) {

        int len = nums.length;
        if (k % len == 0) return;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< len; i++) {
            map.put(i, nums[i]);
        }

        for (int i=0; i< len; i++) {
            nums[(i + k) % len] = map.get((i));
        }
    }

    //翻转 3 次
    public static void solution3(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if (k == 0) return;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public static void reverse(int[] nums, int s, int e) {
        /*int n = s + ((s-e) >> 2);
        for (int i = 0; i<n;i++) {
            int temp = nums[s + i];
            nums[s + i] = nums[e - i];
            nums[e - i] = temp;
        }*/

        while (s < e) {
            int temp = nums[s];
            nums[s++] = nums[e];
            nums[e--] = temp;
        }
    }

}
