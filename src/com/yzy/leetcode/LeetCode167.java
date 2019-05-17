package com.yzy.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

 说明:

 返回的下标值（index1 和 index2）不是从零开始的。
 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 示例:

 输入: numbers = [2, 7, 11, 15], target = 9
 输出: [1,2]
 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode167 {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int[] res = solution2(nums, 9);
        System.out.println(res);
    }

    //一遍hash表  7s
    public static int[] solution(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //key -> 元素值  value -> 数组下标
        for (int n = 0; n < numbers.length; n++) {
            int remaining = target - numbers[n];
            if (map.containsKey(remaining)) {
                return new int[] {map.get(remaining), n+1};
            }
            map.put(numbers[n], n + 1);
        }
        return null;
    }

    //双指针  1s  优于一遍hash表
    public static int[] solution2(int[]  numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) return new int[]{i + 1, j + 1};
            else if (sum > target) j--; //和大于目标值，则说明大数大了，即 j--
            else i++;  //和小于目标值，则说明小数小了，即 i++
        }
        return null;
    }


}
