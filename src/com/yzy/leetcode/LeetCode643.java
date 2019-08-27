package com.yzy.leetcode;

/**
 * Description:
 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

 示例 1:

 输入: [1,12,-5,-6,50,3], k = 4
 输出: 12.75
 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
  

 注意:
 1 <= k <= n <= 30,000。
 所给数据范围 [-10,000，10,000]。
 在真实的面试中遇到过这道题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode643 {

    public static void main(String[] args) {
        int[] nums = new int[] {0,4,0,3,2};
        double head = solution(nums, 1);
        System.out.println(head);

    }
    public static double solution(int[] nums, int k) {

        double sum = 0;  //当前遍历的4个数字的和
        double max = 0;     //历史遍历的4个最大数字的和

        //先计算前k个数的和
        for (int i=0;i<k;i++) {
            sum += nums[i];
        }
        max = sum;

        for (int j = k; j < nums.length; j++) {
            sum = sum + nums[j] - nums[j-k];  //重点:滑动计算连续k的数的和 sum + 前一个数 - 后一个数
            max = Math.max(max, sum);
        }

        return max/k;
    }


}
