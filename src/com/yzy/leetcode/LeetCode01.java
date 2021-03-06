package com.yzy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode01  {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 7, 11, 15};
        int target = 9;
        int[] res = solution1(nums, target);
        System.out.println("" + res[0] + ":" + res[1]);
    }

    public static int[] solution(int[] nums, int target) {
        int[] res = new int[2];
        for (int i=0; i < nums.length - 1; i++) {
            for (int j=i+1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    //两遍hash表 ，
    public static int[] solution1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //key为数组元素的值，value为数组元素下标

        for (int i=0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain) && map.get(remain) != null) {
                return new int[]{i, map.get(remain)};  //map中的下标在后
            }
        }
        return null;
    }

    //一遍hash表 ，
    public static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //key为数组元素的值，value为数组元素下标
        for (int i=0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain) && map.get(remain) != null) {
                return new int[]{map.get(remain), i}; //map中的下标在前
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
